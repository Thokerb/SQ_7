public class Ticket {

    float calculateTicketPrice(float distance, int age){
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


}
