package connect4.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import es.torres.connect4.Connect4;

@AnalyzeClasses(packagesOf = Connect4.class, importOptions = { ImportOption.DoNotIncludeTests.class, DoNotIncludeMainImplementations.class })
public class ArchUnitRulesTest {

    private static final String MODEL_PACKAGE = "..models..";
    private static final String VIEWS_PACKAGE = "..views..";
    private static final String CONTROLLER_PACKAGE = "..controllers..";


    @ArchTest
    static final ArchRule views_should_only_call_controllers =
        noClasses().that().resideInAPackage("..views..")
            .should().dependOnClassesThat().resideInAPackage("..models..");

    @ArchTest
    static final ArchRule layers =
        layeredArchitecture()
            .layer("Controller").definedBy(CONTROLLER_PACKAGE)
            .layer("View").definedBy(VIEWS_PACKAGE)
            .layer("Model").definedBy(MODEL_PACKAGE)

            .whereLayer("View").mayNotBeAccessedByAnyLayer()
            .whereLayer("Controller").mayOnlyBeAccessedByLayers("View")
            .whereLayer("Model").mayOnlyBeAccessedByLayers("Controller");

    @ArchTest
    static final ArchRule naming =
        classes().that()
        .haveNameMatching(".*View*")
        .should().resideInAPackage(VIEWS_PACKAGE);


}
