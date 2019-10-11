package kafka;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class AggregationPerSolarModule {

    private String moduleName;
    private String panelName;
    private int count;
    private double sumPower;
    private double avgPower;

    public AggregationPerSolarModule updateFrom(SolarModuleData data) {
        moduleName = data.getName();
        panelName = data.getPanel();

        count++;
        sumPower += data.getPower();
        avgPower = BigDecimal.valueOf(sumPower / count)
                .setScale(1, RoundingMode.HALF_UP).doubleValue();
        return this;
    }
}
