import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TicketTest {


    @ParameterizedTest
    @ValueSource(floats = {-0.1f,200.1f})
    public void CalculateInvalidTicketPriceTest_byDist(float dist){
        int[] ages = new int[]{0,1,Integer.MAX_VALUE-1, Integer.MAX_VALUE};
        Ticket ticket = new Ticket();
        for (int age:ages){
            Assertions.assertThrows(IllegalArgumentException.class,() -> ticket.calculateTicketPrice(dist,age));
        }
    }


    @ParameterizedTest
    @ValueSource(floats = {0,0.1f, 9.9f,10f})
    public void Q1_Valid(float dist){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(1f,ticket.calculateTicketPrice(dist,21));
    }

    @Test
    public void Q1_Invalid(){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(1f,ticket.calculateTicketPrice(10.1f,21));
        Assertions.assertThrows(IllegalArgumentException.class,() -> ticket.calculateTicketPrice(-0.1f,21));
    }

    @ParameterizedTest
    @ValueSource(floats = {10.1f, 10.2f,99.9f,100f})
    public void Q2_Valid(float dist){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(dist*0.1f,ticket.calculateTicketPrice(dist,21));
    }

    @ParameterizedTest
    @ValueSource(floats = {9.9f,100.1f})
    public void Q2_Invalid(float dist){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(dist*0.1f,ticket.calculateTicketPrice(dist,21));
    }

    @ParameterizedTest
    @ValueSource(floats = {100.1f,100.2f,199.9f,200f})
    public void Q3_Valid(float dist){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(15f,ticket.calculateTicketPrice(dist,21));
    }

    @Test
    public void Q3_Invalid(){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(15f,ticket.calculateTicketPrice(100f,21));
        Assertions.assertThrows(IllegalArgumentException.class,() -> ticket.calculateTicketPrice(200.1f,21));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,151})
    public void TestAgeDiscountInvalid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertThrows(IllegalArgumentException.class,() -> ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,13,14})
    public void TestAgeDiscountQ1(int age){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(0,ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {15})
    public void TestAgeDiscountQ1_invalid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(0,ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {15,16,17,65,149})
    public void TestAgeDiscountQ2_valid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(0.5f,ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {14,19,64})
    public void TestAgeDiscountQ2_invalid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(0.5f,ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {18,19,63,64})
    public void TestAgeDiscountQ3_valid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertEquals(1f,ticket.calculateAgeDiscount(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {17,65})
    public void TestAgeDiscountQ3_invalid(int age){
        Ticket ticket = new Ticket();
        Assertions.assertNotEquals(1f,ticket.calculateAgeDiscount(age));
    }




}
