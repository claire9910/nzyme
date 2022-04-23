package horse.wtf.nzyme.rest.responses.taps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

@AutoValue
public abstract class TapDetailsResponse {

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("local_time")
    public abstract DateTime localTime();

    @JsonProperty("processed_bytes_total")
    public abstract Long processedBytesTotal();

    @JsonProperty("processed_bytes_10")
    public abstract Long processedBytes10();

    @JsonProperty("memory_total")
    public abstract Long memoryTotal();

    @JsonProperty("memory_free")
    public abstract Long memoryFree();

    @JsonProperty("memory_used")
    public abstract Long memoryUsed();

    @JsonProperty("cpu_load")
    public abstract Double cpuLoad();

    @JsonProperty("created_at")
    public abstract DateTime createdAt();

    @JsonProperty("updated_at")
    public abstract DateTime updatedAt();

    @JsonProperty("description")
    public abstract String description();

    public static TapDetailsResponse create(String name, DateTime localTime, Long processedBytesTotal, Long processedBytes10, Long memoryTotal, Long memoryFree, Long memoryUsed, Double cpuLoad, DateTime createdAt, DateTime updatedAt, String description) {
        return builder()
                .name(name)
                .localTime(localTime)
                .processedBytesTotal(processedBytesTotal)
                .processedBytes10(processedBytes10)
                .memoryTotal(memoryTotal)
                .memoryFree(memoryFree)
                .memoryUsed(memoryUsed)
                .cpuLoad(cpuLoad)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .description(description)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_TapDetailsResponse.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder localTime(DateTime localTime);

        public abstract Builder processedBytesTotal(Long processedBytesTotal);

        public abstract Builder processedBytes10(Long processedBytes10);

        public abstract Builder memoryTotal(Long memoryTotal);

        public abstract Builder memoryFree(Long memoryFree);

        public abstract Builder memoryUsed(Long memoryUsed);

        public abstract Builder cpuLoad(Double cpuLoad);

        public abstract Builder createdAt(DateTime createdAt);

        public abstract Builder updatedAt(DateTime updatedAt);

        public abstract Builder description(String description);

        public abstract TapDetailsResponse build();
    }

}
