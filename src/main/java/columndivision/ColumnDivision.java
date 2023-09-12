package columndivision;

import columndivision.divisionprocess.DivisionProcess;

public class ColumnDivision 
{
    public static void main(String[] args) {

        DivisionProcess myDivisionProces = new DivisionProcess();

        System.out.println(myDivisionProces.divisionResult(78945, 4));
    }
}
