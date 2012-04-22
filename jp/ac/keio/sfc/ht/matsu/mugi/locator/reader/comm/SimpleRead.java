package jp.ac.keio.sfc.ht.matsu.mugi.locator.reader.comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

import jp.ac.keio.sfc.ht.matsu.mugi.util.Param;

/**
 * �P���ɁCRS232����ǂݍ��݁C���X�i�֒ʒm����
 * 
 * <p>�s�̍\��</p>
 * <code>hogehogehogehogehogheohg\r\n</code>
 * 
 * @author matsu
 *
 */
public class SimpleRead implements SerialPortEventListener {
    
    static CommPortIdentifier portId;

    static Enumeration portList;

    InputStream inputStream;

    SerialPort serialPort;

    StringBuffer stringbuffer = new StringBuffer();

    SerialLineListener listener;

    
    /**
     * �e�X�g�R�[�h
     * @param args
     */
    public static void main(String[] args) {

        SimpleRead reader = new SimpleRead();

    }

    /**
     * �R���X�g���N�^
     *
     */
    public SimpleRead() {

        portList = CommPortIdentifier.getPortIdentifiers();

        while (portList.hasMoreElements()) {

            portId = (CommPortIdentifier) portList.nextElement();

            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(Param.COM)) {
                    // if (portId.getName().equals("/dev/term/a")) {
                    // SimpleRead reader = new SimpleRead();
                    init();
                }
            }
        }

    }

    
    /**
     * ������
     *
     */
    public void init() {

        try {

            serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
            inputStream = serialPort.getInputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            serialPort.setSerialPortParams(4800, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

        } catch (PortInUseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        } catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
        }
    }
    
    
    
    

    /**
     * �V���A���|�[�g�̃C�x���g���X�i
     */
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
        case SerialPortEvent.BI:
        case SerialPortEvent.OE:
        case SerialPortEvent.FE:
        case SerialPortEvent.PE:
        case SerialPortEvent.CD:
        case SerialPortEvent.CTS:
        case SerialPortEvent.DSR:
        case SerialPortEvent.RI:
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
        case SerialPortEvent.DATA_AVAILABLE:
            byte[] readBuffer = new byte[256];

            try {

                int numBytes = 0;
                while (inputStream.available() > 0) {
                    numBytes = inputStream.read(readBuffer);
                }

                // 1�������o��
                String achar = new String(readBuffer, 0, numBytes);
                
                // \r��������C���܂킸break
                if(achar.matches("\r")) break;
                

                if (!achar.matches("\n")) 
                    stringbuffer.append(achar);
                

                if (achar.equals("\n")) {
                 
                     //Log.debug(">>"+stringbuffer.toString()+"<<");
                    

                    // ���X�i�֍s��ʒm
                    if (listener != null) {
                        listener.serialData(stringbuffer.toString());
                    }
                    
                    // �N���A
                    stringbuffer = new StringBuffer();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;

        }
    }

    /**
     * ���X�i�ǉ�
     * @param listener
     */
    public void addSerialLineListener(SerialLineListener listener) {
        this.listener = listener;
    }
}
