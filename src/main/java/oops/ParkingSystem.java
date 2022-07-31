package oops;

public class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            boolean isSpaceAvailable ;
            switch(carType){
                case 1:
                    isSpaceAvailable =  this.big !=0;
                    if(isSpaceAvailable) this.big--;
                    break;
                case 2:
                    isSpaceAvailable = this.medium !=0;
                    if(isSpaceAvailable) this.medium--;
                    break;
                case 3:
                    isSpaceAvailable = this.small !=0;
                    if(isSpaceAvailable) this.small--;
                    break;
                default:
                    return false;
            }
            return isSpaceAvailable;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
