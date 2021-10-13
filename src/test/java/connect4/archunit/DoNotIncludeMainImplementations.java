package connect4.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;
import java.util.regex.Pattern;

public class DoNotIncludeMainImplementations implements ImportOption {

    private static final Pattern MAPPER_IMPL_PATTERN = Pattern.compile(".*Connect4\\.class");

    @Override
    public boolean includes(Location location) {
        return !location.matches(MAPPER_IMPL_PATTERN);
    }
}
