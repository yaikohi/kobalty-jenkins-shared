package online.kobalty.jenkins.library

@Grab('com.moandjiezana.toml:toml4j:0.7.2')
import com.moandjiezana.toml.Toml

/**
 * @Param fileName - The filename of the toml file. Should be in `main/resources/< FILENAME >.toml`. Do not provide the path.
 */
class TomlUtils {
    String fileName

    TomlUtils(String fileName) {
        this.fileName = "/${ fileName }"
    }

    /**
     Returns a map representative of the provided `.toml` file.
     */
    def loadConfig() {
        try {
            URL tomlResource = getClass().getResource(fileName)
            String tomlResourcePath = tomlResource.getPath()
            String tomlString = new File(tomlResourcePath).text

            return new Toml().read(tomlString)
        } catch (FileNotFoundException err) {
            println "Error: ${err.message}"
            println "Did you put the file in the `main/resources` directory?"
            return null
        } catch (IOException err) {
            println "Error reading TOML file: ${err.message}"
            return null
        } catch (NullPointerException err) {
            println "Error: ${err.message}"
            println "Did you put the file in the `main/resources` directory?"
            return null
        } catch (Exception err) {
            println "Error parsing TOML data: ${err.message}"
            return null
        }
    }
}