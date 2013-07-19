package org.kunicki.swaggercsv

import groovy.json.JsonSlurper

/**
 * @author Jacek Kunicki
 */
class JsonReader {

    static def readJson(url) {
        def connection = new URL(url).openConnection()
        connection.setRequestProperty('Accept', 'application/json')
        connection.responseCode == 200 ? new JsonSlurper().parseText(connection.content.text) : null
    }
}
