/*
 * �쐬��: 2004/12/17
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎��փW�����v:
 * �E�B���h�E - �ݒ� - Java - �R�[�h�E�X�^�C�� - �R�[�h�E�e���v���[�g
 */
package jp.ac.keio.sfc.ht.matsu.mugi.util;

import java.util.Arrays;

/**
 * @author matsu
 *
 * TODO ���̐������ꂽ�^�R�����g�̃e���v���[�g��ύX����ɂ͎��փW�����v:
 * �E�B���h�E - �ݒ� - Java - �R�[�h�E�X�^�C�� - �R�[�h�E�e���v���[�g
 */
public class HashTest {
	
	public HashTest(){
		
		String words = "hgoehgoeah";
		
		
		System.out.println(Arrays.hashCode(words.toCharArray()));
		
	}
	
	public static void main(String args[]){
		
		HashTest tset = new HashTest();
		
	}

}
