/**Dongzheng (Elizabeth)Xu
 * This operation magnifies by making the image bigger (one pixel on original is equal to 4 pixels on resulting image).
 * 
 * Last edited: February 3 2019
 **/
import java.awt.Color;

public class MagnifyOperation implements ImageOperation {

	@Override
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;// num of rows in image
		int numOfColumns = imageArray[0].length;//num of columns in image

		Color [][] result = new Color [2*numOfRows][2*numOfColumns]; //creates array 2 times as large as original

		for(int r=0; r<numOfRows; r++) {//run through each column and row
			for(int c=0; c<numOfColumns; c++) {
				//set 4 pixels (in a square) equal to colour of the original pixel
				result[2*r][2*c]=imageArray[r][c];// use top left pixel of magnified 4 pixel square as a reference
				result[2*r+1][2*c]=imageArray[r][c];//right pixel of magnified square
				result[2*r][2*c+1]=imageArray[r][c];//down 
				result[2*r+1][2*c+1]=imageArray[r][c];//bottom right
			}
		}
		return result;
	}

}