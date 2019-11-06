package org.devll.samples;

import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "sample")
public class SampleProperties {

    @Min(3)
    private Integer minInt;

    public Integer getMinInt() {
        return minInt;
    }

    public void setMinInt(Integer minInt) {
        this.minInt = minInt;
    }
}
