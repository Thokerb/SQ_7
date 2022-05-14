public class Ticket {

    float calculateTicketPrice(float distance, int age){
        float discount = calculateAgeDiscount(age);
        float distancePrice = calculateDistancePrice(distance);
        return discount * distancePrice;
    }

    protected float calculateDistancePrice(float distance){
        if(distance<0 || distance > 200){
            throw new IllegalArgumentException("Invalid distance");
        }

        if(distance<=10){
            return 1f;

        }
        if(distance<=100){
            return distance*0.1f;
        }
        return 15f;
    }

    protected float calculateAgeDiscount(int age) throws  IllegalArgumentException{
        if(age<0||age>150){
            throw new IllegalArgumentException("Invalid age");
        }
        if(age <15){
            return 0f;
        }
        if(age<18){
            return 0.5f;
        }
        if(age>64){
            return 0.5f;
        }
        return 1f;
    }


}
