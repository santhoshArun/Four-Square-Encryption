package encryption;

import java.util.Scanner;

public class FourSquareEncryption {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String inText = "abcdefghijklmnopqrstuvwxyz0123456789", keyOne, keyTwo, plainText, cipherText;
		int keyOneLength, keyTwoLength, inTextLength, k1l1 = 0, k1l2 = 0, k1len = 0, i1len = 0, k2l1 = 0, k2l2 = 0, k2len = 0, i2len = 0, q1l1 = 0, q1l2 = 0, q3l1 = 0, q3l2 = 0, q1len = 0, q3len = 0;
		char currentChar;
		
		//creating 4 quadrant arrays
		char quadOne[][] = new char[6][6];
		char quadTwo[][] = new char[6][6]; 
		char quadThree[][] = new char[6][6]; 
		char quadFour[][] = new char[6][6];
		
		//initializing array values
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				quadOne[i][j] = '0';
				quadTwo[i][j] = '0';
				quadThree[i][j] = '0';
				quadFour[i][j] = '0';
			}
		}
		
		//get Keys
		System.out.print("Enter the encryption key one: ");
		keyOne = sc.nextLine();
		System.out.print("Enter the encryption key two: ");
		keyTwo = sc.nextLine();
		
		keyOneLength = keyOne.length();
		keyTwoLength = keyTwo.length();
		inTextLength = inText.length();
		
		//assign key one to quad four array												//quad four
		while(k1l1 < 6 && k1len < keyOneLength) {
			k1l2 = 0;
			while(k1l2<6 && k1len < keyOneLength) {
				
				currentChar = keyOne.charAt(k1len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadFour[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadFour[k1l1][k1l2] = currentChar;
					k1l2++;
				}
				k1len++;
			}
			k1l1++;

		}

		--k1l1;
		
		//assign remaining values to quad four array
		while(k1l1 < 6 && i1len < inTextLength) {
			
			while(k1l2<6 && i1len < inTextLength) {
				
				currentChar = inText.charAt(i1len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadFour[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadFour[k1l1][k1l2] = currentChar;
					k1l2++;
				}
				i1len++;
			}
			k1l1++;
			k1l2 = 0;
		}

		
		//assign key two to quad two array												//quad two
		while(k2l1 < 6 && k2len < keyTwoLength) {
			k2l2 = 0;
			while(k2l2<6 && k2len < keyTwoLength) {
				
				currentChar = keyTwo.charAt(k2len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadTwo[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadTwo[k2l1][k2l2] = currentChar;
					k2l2++;
				}
				k2len++;
			}
			k2l1++;

		}

		--k2l1;
		
		//assign remaining values to quad two array
		while(k2l1 < 6 && i2len < inTextLength) {
			
			while(k2l2<6 && i2len < inTextLength) {
				
				currentChar = inText.charAt(i2len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadTwo[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadTwo[k2l1][k2l2] = currentChar;
					k2l2++;
				}
				i2len++;
			}
			k2l1++;
			k2l2 = 0;
		}

		//assign quad one array															//quad one
		while(q1l1 < 6 && q1len < inTextLength) {
			q1l2 = 0;	
			while(q1l2<6 && q1len < inTextLength) {
				
				currentChar = inText.charAt(q1len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadOne[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadOne[q1l1][q1l2] = currentChar;
					q1l2++;
				}
				q1len++;
			}
			q1l1++;
		
		}
		
		//assign quad three array														//quad three
		while(q3l1 < 6 && q3len < inTextLength) {
			q3l2 = 0;	
			while(q3l2<6 && q3len < inTextLength) {
				
				currentChar = inText.charAt(q3len);
				int flag = 0;
				
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						if(quadThree[i][j] == currentChar) {
							flag = 1;
						}
					}
				}
				
				if(flag == 0) {
					quadThree[q3l1][q3l2] = currentChar;
					q3l2++;
				}
				q3len++;
			}
			q3l1++;
		
		}

		String choice;
		System.out.print("Enter 'e' for Encryption and 'd' for Decryption: ");
		choice = sc.nextLine();

		if(choice.equalsIgnoreCase("e")) {
			
			//get plain text
			int txtLength;
			System.out.print("\n\nEnter the plain text: ");
			plainText = sc.nextLine();
			plainText = plainText.replace(" ", "").toLowerCase();
			txtLength = plainText.length();
		
			//encryption
			int q4r = 0, q4c = 0, q2r = 0, q2c = 0, counter = 0;
			
			System.out.print("\nEncrypted text: ");
			while(counter < txtLength) {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
					
						if(quadFour[i][j] == plainText.charAt(counter)) {
							q4r = i;
							q4c = j;
						}
						
						if(counter + 1 < txtLength) {
							
							if(quadTwo[i][j] == plainText.charAt(counter + 1)) {
								q2r = i;
								q2c = j;
							}
							
						}
					
					}
				}
				
				System.out.print(quadThree[q2r][q4c]);
				System.out.print(quadOne[q4r][q2c]);
				
				counter += 2;
				
			}
		} else if(choice.equalsIgnoreCase("d")) {
			
			//get cipher text
			int txtLen;
			System.out.print("\n\nEnter the cipher text: ");
			cipherText = sc.nextLine();
			cipherText = cipherText.replace(" ", "").toLowerCase();
			txtLen = cipherText.length();
			
			//decryption
			int q3r = 0, q3c = 0, q1r = 0, q1c = 0, count = 0;
			
			System.out.print("\nDecrypted text: ");
			while(count < txtLen) {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
					
						if(quadThree[i][j] == cipherText.charAt(count)) {
							q3r = i;
							q3c = j;
						}
						
						if(count + 1 < txtLen) {
							
							if(quadOne[i][j] == cipherText.charAt(count + 1)) {
								q1r = i;
								q1c = j;
							}
							
						}
					
					}
				}
				
				System.out.print(quadFour[q1r][q3c]);
				System.out.print(quadTwo[q3r][q1c]);				
				
				count += 2;
			
			}
			
		}
		
	}

}