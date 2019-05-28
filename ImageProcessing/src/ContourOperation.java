/**Dongzheng (Elizabeth)Xu
 * This operation changes finds the contour of an image using colour distance, if the colour distance is greater than 65 the
 * pixel is black, otherwise its white.
 * 
 * Last edited: February 3 2019
 **/
import java.awt.Color;
import java.math.*;

public class ContourOperation implements ImageOperation {

	@Override
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;// num of rows in image
		int numOfColumns = imageArray[0].length;//num of columns in image
		int distanceDown,distanceUp,distanceRight,distanceLeft,distanceBtmRt,distanceBtmLft,distanceTpRt,distanceTpLft;
		
		Color [][] result = new Color [numOfRows][numOfColumns]; //each element rep one pixel
		
		for(int r=0; r<numOfRows; r++) {//run through each column and row of image
			for(int c=0; c<numOfColumns; c++) {

				result[r][c]= new Color (255,255,255);	//set default pixel color to white 

			/******************CHECK IF THE CORNER PIXELS(3 surrounding pixels) SHOULD BE BLACK******************/
				if(c==0 && r==0) { // check surrounding pixels of single top left corner pixel
					distanceDown= distance(r,c,r,c+1,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);
					distanceBtmRt = distance (r,c,r+1,c+1,imageArray);

					if (distanceDown>65||distanceRight>65||distanceBtmRt>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}
				else if(c==0 && r==(numOfRows-1)) { // check surrounding pixels of single top right corner pixel
					distanceDown= distance(r,c,r,c+1,imageArray);
					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceBtmLft = distance (r,c,r-1,c+1,imageArray);

					if (distanceDown>65||distanceLeft>65||distanceBtmLft>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				else if(c==(numOfColumns-1) && r==(numOfRows-1)) { // check surrounding pixels pf bottom right corner 
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceTpLft = distance (r,c,r-1,c-1,imageArray);

					if (distanceUp>65||distanceLeft>65||distanceTpLft>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				else if(c==(numOfColumns-1) && r==0) { // check surrounding of bottom left corner pixel
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);
					distanceTpRt = distance (r,c,r+1,c-1,imageArray);

					if (distanceUp>65||distanceRight>65||distanceTpRt>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				/************************CHECK THE SIDE PIXELS (5 surrounding pixels) SHOULD BE BLACK****************/
				if (c>0 && c<numOfColumns-1 && r==0) { //left side pixels (not including 2 corner pixels)
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceTpRt = distance (r,c,r+1,c-1,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);
					distanceBtmRt = distance (r,c,r+1,c+1,imageArray);
					distanceDown= distance(r,c,r,c+1,imageArray);

					if (distanceUp>65||distanceTpRt>65||distanceRight>65||distanceBtmRt>65||distanceDown>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				else if (c>0 && c<numOfColumns-1 && r==numOfRows-1) { //right side pixels (not including 2 corner pixels)
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceTpLft = distance (r,c,r-1,c-1,imageArray);
					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceBtmLft = distance (r,c,r-1,c+1,imageArray);
					distanceDown= distance(r,c,r,c+1,imageArray);


					if (distanceUp>65||distanceTpLft>65||distanceLeft>65||distanceBtmLft>65||distanceDown>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				else if (r>0 && r<numOfRows-1 && c==0) { //top side pixels (not including 2 corner pixels)
					distanceBtmRt = distance (r,c,r+1,c+1,imageArray);
					distanceBtmLft = distance (r,c,r-1,c+1,imageArray);
					distanceDown= distance(r,c,r,c+1,imageArray);
					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);

					if (distanceBtmRt>65||distanceBtmLft>65||distanceDown>65||distanceLeft>65||distanceRight>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				else if (r>0 && r<numOfRows-1 && c==numOfColumns-1) { //bottom side pixels (not including 2 corner pixels)

					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceTpRt = distance (r,c,r+1,c-1,imageArray);
					distanceTpLft = distance (r,c,r-1,c-1,imageArray);

					if (distanceLeft>65||distanceRight>65||distanceUp>65||distanceTpRt>65||distanceTpLft>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}

				/******************************CHECK IF INTERIOR PIXELS (8surrounding pixels) SHOULD BE BLACK ***************/
				if(c>0 && r>0 && c<numOfColumns-1 && r<numOfRows-1) {
					distanceLeft = distance(r,c,r-1,c,imageArray);
					distanceRight = distance(r,c,r+1,c,imageArray);
					distanceUp= distance(r,c,r,c-1,imageArray);
					distanceTpRt = distance (r,c,r+1,c-1,imageArray);
					distanceTpLft = distance (r,c,r-1,c-1,imageArray);
					distanceBtmRt = distance (r,c,r+1,c+1,imageArray);
					distanceBtmLft = distance (r,c,r-1,c+1,imageArray);
					distanceDown= distance(r,c,r,c+1,imageArray);

					if (distanceLeft>65||distanceRight>65||distanceUp>65||distanceTpRt>65||distanceTpLft>65||distanceBtmRt>65||distanceBtmLft>65||distanceDown>65) {//set colour to black 
						result[r][c]= new Color (0,0,0);
					}
				}
			}
		}
		return result;

	}	

	public int distance(int r1, int c1,int r2, int c2, Color[][] imageArray) { // takes in position of first and second pxl returns distance

		int redD = imageArray[r1][c1].getRed() - imageArray[r2][c2].getRed();
		int greenD =  imageArray[r1][c1].getGreen() - imageArray[r2][c2].getGreen();
		int blueD = imageArray[r1][c1].getBlue()- imageArray[r2][c2].getBlue();

		int distance = (int) Math.sqrt(Math.pow(redD,2)+Math.pow(greenD,2)+Math.pow(blueD,2));

		return distance;

	}
}
