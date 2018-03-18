package net.dankito.readability4j.extended

import net.dankito.readability4j.Readability4J
import net.dankito.readability4j.additional.AdditionalReadability4JTests
import net.dankito.readability4j.model.PageTestData
import net.dankito.readability4j.model.ReadabilityOptions
import java.util.*


open class AdditionalReadability4JExtendedTests : AdditionalReadability4JTests() {

    // TODO: http://www.kleinezeitung.at/oesterreich/5298693/Maskottchen-bestraft_Verhuellungsverbot_In-Wien-musste-ein-Hai

    // TODO: https://www.nytimes.com/interactive/2017/12/19/us/ford-chicago-sexual-harassment.html

    // TODO: https://www.republik.ch/2018/02/19/interview-eribon-teil1

    override fun createReadability4J(url: String, testData: PageTestData): Readability4J {
        // Provide one class name to preserve, which we know appears in a few
        // of the test documents.
        return Readability4JExtended(url, testData.sourceHtml,
                ReadabilityOptions(additionalClassesToPreserve = Arrays.asList("caption")))
    }

    override fun loadTestData(testPageFolderName: String, pageName: String): PageTestData {
        var testData = super.loadTestData(testPageFolderName, pageName)

        try {
            // check if test case has a different expected output placed in expected-extended.html
            val expectedExtendedOutput = getFileContentFromResource(testPageFolderName, pageName, "expected-extended.html")

            testData = PageTestData(testData.pageName, testData.sourceHtml, expectedExtendedOutput, testData.expectedMetadata)
        } catch(ignored: Exception) { }

        return testData
    }

}