import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import utils.HBaseUtil;

public class ScanContentTest {
    String startTime = "2017-01-01";
    String stopTime = "2017-03-01";

    //15837312345 13737399999
    public static void main(String[] args) {
        Scan scan = new Scan();
        //regionCode_15837312345_20170110152430_13737399999_1_0360

        //regionCode_13737399999_20170110152430_15837312345_0_0360
        String regionCodeCaller = HBaseUtil.genRegionCode("15837312345", "201701", 6);
        String regionCodeCallee = HBaseUtil.genRegionCode("13737399999", "201701", 6);

        scan.setStartRow(Bytes.toBytes(regionCodeCaller + "_15837312345_201701"));
        scan.setStopRow(Bytes.toBytes(regionCodeCaller + "_15837312345_201702"));
    }
}
