package sg.nus.iss.sbhazelcast.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class HazelCastConfiguration {

    @Bean
    public Config hazelCastConfig() {
        // v3.6 (deprecated)
        // return new Config()
        // .setInstanceName("hazelcast-instance")
        // .addMapConfig(new MapConfig()
        // .setName("employeeCache")
        // .setMaxSizeConfig(new MaxSizeConfig()
        // .setSize(200)
        // .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE))
        // .setEvictionPolicy(EvictionPolicy.LRU)
        // .setTimeToLiveSeconds(300));

        // found solution:
        // https://stackoverflow.com/questions/68925343/import-issue-with-com-hazelcast-config-maxsizeconfig
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig()
                        .setName("employeeCache")
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(200)
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                                .setEvictionPolicy(EvictionPolicy.LRU))
                        .setTimeToLiveSeconds(300));
    }
}
