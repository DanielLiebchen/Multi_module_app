package liebchen.daniel.service.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.collections.impl.collector.BigDecimalSummaryStatistics;

import java.math.BigDecimal;
import java.util.IntSummaryStatistics;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistics <T>{
    T min;
    T average;
    T max;

    public static Statistics<Double> toDoubleStatistics(IntSummaryStatistics stats){
        return Statistics.<Double>builder()
                .min((double)stats.getMin())
                .average(stats.getAverage())
                .max((double)stats.getMax())
                .build();
    }

    public static Statistics<BigDecimal> toBigDecimalStatistics(BigDecimalSummaryStatistics stats){
        return Statistics.<BigDecimal>builder()
                .min(stats.getMin())
                .average(stats.getAverage())
                .max(stats.getMax())
                .build();
    }
}
