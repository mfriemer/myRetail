package com.myRetail.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

/**
 * Created by miker on 4/30/17.
 */

@Configuration
class MyRetailConfig {
    @Value('${client.resourceUri:http://redsky.target.com}')
    private String resourceUri
}
