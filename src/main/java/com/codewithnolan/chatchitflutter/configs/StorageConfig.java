package com.codewithnolan.chatchitflutter.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("storage")
public class StorageConfig {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

}
