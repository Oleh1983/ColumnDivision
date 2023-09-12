package columndivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import columndivision.divisionprocess.DivisionProcess;

class ColumnDivisionTest {
    
    DivisionProcess divisionProcess;
    
    @BeforeEach
    void init() {
        divisionProcess = new DivisionProcess();
    }

    @Test
    @DisplayName("Is not empty")
    void methodDivideNumbers_IsNotEmpty() {

        String tempInt = divisionProcess.divisionResult(1245,38);
        
        assertFalse(tempInt.isEmpty());

    }
    
    @Test
    @DisplayName("Is not null")
     void methodDivideNumbers_IsNotNuul() {
        
       String tempInt = divisionProcess.divisionResult(245,38);

        assertNotNull(tempInt);

    }
    @Test
    @DisplayName("Is empty when the dividend is zero and the divisor is an integer")
    void methodDivideNumbers_IsEmpty() {
        
        String tempInt = divisionProcess.divisionResult(0,4);
        
        assertTrue(tempInt.isEmpty());
        
    }
    @Test
    @DisplayName("Is one when the dividend is one and divisor is one too")
     void methodDivideNumbers_IsOneWhenDividendIsOneAndDivisorIsOneToo() {
        
       String tempInt = divisionProcess.divisionResult(1,1);
       
        assertEquals( " _1|1\n"
                    + "  1|-\n"
                    + "  -|1\n"
                    + "   0\n", tempInt);

    }

}
