# image-processing
## Description:
Implements four basic image processing operations on a 2-dimensional digital image.
Four operations are image thresholding,magnification,contouring and color inversion.

## Notable files:
The main method is in "ImageProcessing\ImageProcessing.java"
Sample images are included ("dragon1.jpg" etc..)

## Prequisite:
Eclipse IDE

## Prepare for Deployment:
*Have a configuration file  (..src\image.txt is the configuration file)*

  Format of content in config. file: "Color" + *space* + location of image to be processed + keyword of operation to be performed 
  Operation keywords:(Magnify,Thresholding,Contour,Inverse,Adjustment)

  Examples include:
  Color C:\Users\Eliza\ImageProcessing\face.jpg Magnify 
  Color C:\Users\Eliza\ImageProcessing\mug1.jpg Thresholding  
  
*Have an output folder (..src\output is output folder)

## Deployment:
*Change configuration file (image location & operation keyword) according to desired image and deployment operation for image processing*
*Run the program->select image.txt as config. file->select output folder for output -> finished (processed image is in output folder)*
  
  Console should display: "Image file"+ location of image processed+"saved"  if successfully processed:
  
  Example:  
  Image file "C:\Users\Eliza\ImageProcessing\mug1_output_Thresholding.jpg" saved
  





