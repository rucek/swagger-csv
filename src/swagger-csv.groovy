import org.kunicki.swaggercsv.JsonReader

/**
 * @author Jacek Kunicki
 */

final def API_DOCS_PATH = '/api-docs'
final def headers = ['method', 'path', 'description', 'parameters']

def baseUrl = args[0]
def apiDocs = JsonReader.readJson(baseUrl + API_DOCS_PATH)
def writer = new File('api.csv').newWriter()

writer.println headers.join(';')

apiDocs.apis.each { controller ->
    def controllerJson = JsonReader.readJson(baseUrl + controller.path)
    writer.println controllerJson.resourcePath
    controllerJson.apis.each { api ->
        api.operations.each { operation ->
            def params = operation.parameters?.collect { "${it.name}: ${it.dataType}" }?.join('\n')
            writer.println "${operation.httpMethod};${api.path};${operation.summary};\"${params}\""
        }
    }
}

writer.flush()
writer.close()