package twoPointers;

public class FlipAndInvertImage {
    /**
     * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
     *
     * To flip an image horizontally means that each row of the image is reversed.
     *
     * For example, flipping [1,1,0] horizontally results in [0,1,1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     * For example, inverting [0,1,1] results in [1,0,0].
     *
     * Final transformation
     * step1 - [1,1,0,1,1,0]
     * flip  - [0,1,1,0,1,1]
     * inver - [1,0,0,1,0,0]
     *
     * Approach-->place 2 pointers  and invert those which are equal
     * to swap binary
     *  a = 1-a;
     *  b=a
     * @param image
     * @return
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i< image.length; i++){
            int left_pointer = 0;
            int right_pointer = image[i].length -1;
            while (left_pointer <= right_pointer){
                if(image[i][left_pointer] == image[i][right_pointer]){
                    image[i][left_pointer] = 1-image[i][left_pointer];
                    image[i][right_pointer] = image[i][left_pointer];
                }
                left_pointer++;
                right_pointer--;
            }
        }
        return image;
    }
}
