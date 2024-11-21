package online.kobalty.jenkins.library

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TomlUtilsTest {
    @Test
    void "loadConfig should return a map of values when the TOML file is valid"() {
//      --- GIVEN
        def tomlUtils = new TomlUtils("test.toml")
//      --- WHEN
        def config = tomlUtils.loadConfig()
//      --- THEN
        assertEquals(config.name, "Test")
        assertEquals(config.value, 123)
    }
    @Test
    void "loadConfig should return null when the TOML file is not found"() {
//      --- GIVEN
        def tomlUtils = new TomlUtils("nonexistent.toml")
//      --- WHEN
        def config = tomlUtils.loadConfig()
//      --- THEN
        assertNull(config)
    }

    @Test
    void "loadConfig should return null when the TOML file is invalid"() {
//      --- GIVEN
        def tomlUtils = new TomlUtils("invalid.toml")

//      --- WHEN
        def config = tomlUtils.loadConfig()

//      --- THEN
        assertNull(config)
    }
}