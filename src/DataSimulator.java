import Data.NozzleMeasure;
import Data.Refuel;
import Data.TankMeasure;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by kacper on 2018-07-04.
 */
public class DataSimulator{
    private TankMeasure tankMeasureData = new TankMeasure();
    private NozzleMeasure nozzleMeasureData = new NozzleMeasure();
    private Refuel refuelData = new Refuel();

    //Zmienne używane do wczytywania tekstu z plików wyjściowych
    String separator = ";";
    Integer separatorIndex = 0;
    Integer separatorStartIndex = 0;
    Integer separatorEndIndex = 0;
    String currentText = "";


    public void simulate(){
        new Thread(new Runnable() {
            public void run() {
                getTankMeasureData();
                getNozzleMeasureData();
                getRefuelData();
                System.out.println(tankMeasureData.getDatetime());
                System.out.println(nozzleMeasureData.getTotalCounter());
                System.out.println(refuelData.getFillingSpeed());

            }
        }).start();
    }

    public void getTankMeasureData(){

        try{
            FileInputStream is;
            BufferedReader reader;
            final File file = new File(System.getProperty("user.dir") + "/tankMeasures.log");

            if (file.exists()) {
                is = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                //while((line = reader.readLine()) != null){
                    currentText = line;
                    separatorIndex = currentText.indexOf(separator);
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    tankMeasureData.setDatetime(LocalDateTime.parse(currentText.substring(0,separatorIndex), f));
                    separatorIndex++;

                    for(int i = 0; i<2; i++){
                        separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                        separatorIndex = separatorStartIndex + 1;
                    }
                    separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                    tankMeasureData.setTankId(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));

                    for(int i = 0; i<2; i++){
                        separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                        separatorIndex = separatorStartIndex + 1;
                    }
                    separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);

                    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                    Number number = format.parse(currentText.substring(separatorIndex, separatorEndIndex));
                    double d = number.doubleValue();
                    tankMeasureData.setFuelVolume(d);

                    for(int i = 0; i<1; i++){
                        separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                        separatorIndex = separatorStartIndex + 1;
                    }
                    separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                    tankMeasureData.setFuelTemperature(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));
                //}
            }

        }catch (IOException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getRefuelData() {
        try{
            FileInputStream is;
            BufferedReader reader;
            final File file = new File(System.getProperty("user.dir") + "/refuel.log");

            if (file.exists()) {
                is = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                //while((line = reader.readLine()) != null){
                currentText = line;
                separatorIndex = currentText.indexOf(separator);
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                refuelData.setDatetime(LocalDateTime.parse(currentText.substring(0,separatorIndex), f));

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                System.out.println(separatorIndex);
                System.out.println(separatorEndIndex);
                refuelData.setTankId(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number = format.parse(currentText.substring(separatorIndex, separatorEndIndex));
                double d = number.doubleValue();
                refuelData.setFuelVolume(d);

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.length();
                number = format.parse(currentText.substring(separatorIndex, separatorEndIndex));
                d = number.doubleValue();
                refuelData.setFillingSpeed(d);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getNozzleMeasureData() {
        try{
            FileInputStream is;
            BufferedReader reader;
            final File file = new File(System.getProperty("user.dir") + "/nozzleMeasures.log");

            if (file.exists()) {
                is = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                //while((line = reader.readLine()) != null){
                currentText = line;
                separatorIndex = currentText.indexOf(separator);
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                nozzleMeasureData.setDatetime(LocalDateTime.parse(currentText.substring(0,separatorIndex), f));
                separatorIndex++;

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                nozzleMeasureData.setGunId(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                nozzleMeasureData.setTankId(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number = format.parse(currentText.substring(separatorIndex, separatorEndIndex));
                double d = number.doubleValue();
                nozzleMeasureData.setLiterCounter(d);

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.indexOf(separator, separatorIndex+1);
                number = format.parse(currentText.substring(separatorIndex, separatorEndIndex));
                d = number.doubleValue();
                nozzleMeasureData.setTotalCounter(d);

                separatorStartIndex = currentText.indexOf(separator, separatorIndex);
                separatorIndex = separatorStartIndex + 1;
                separatorEndIndex = currentText.length();
                nozzleMeasureData.setStatus(Integer.valueOf(currentText.substring(separatorIndex, separatorEndIndex)));
            }

        }catch (IOException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
