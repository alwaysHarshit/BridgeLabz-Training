package scenariobased.future.logistics;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public GoodsTransport parseDetails(String input){
        String[] split = input.split(":");

        System.out.println(Arrays.toString(split));

        String transportId = split[0];
        String transportDate = split[1];
        int transportRating = Integer.parseInt(split[2]);
        String transportType=split[3];

        validateTransportId(transportId);


        if(transportType.equalsIgnoreCase("BrickTransport")){
            float brickSize=Float.parseFloat(split[4]);
            int brickQuantity=Integer.parseInt(split[5]);
            float brickPrice=Float.parseFloat(split[6]);

            return new BrickTransport(transportId,transportDate,transportRating,brickSize,brickQuantity,brickPrice);
        }
        else{
            float timberLength=Float.parseFloat(split[4]);
            float timberRadius=Float.parseFloat(split[5]);
            String timberType=split[6];
            float timberPrice=Float.parseFloat(split[7]);
            return new TimberTransport(transportId,transportDate,transportRating,timberLength,timberRadius,timberType,timberPrice);
        }
    }
    public boolean validateTransportId (String transportId){
        String regex="^RTS[0-9]{3}[A-Z]$";
        Matcher matcher = Pattern.compile(regex).matcher(transportId);

        if(!matcher.matches()) throw new RuntimeException("Transport Id "+transportId+" is invalid");
        return true;

    }
    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        } else {
            return "BrickTransport";
        }

    }
}
