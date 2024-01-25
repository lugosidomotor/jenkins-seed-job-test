// Define a freestyle job
freestyleJob('freestyle-dsl-job') {
    // SCM step for code checkout
    scm {
        git('https://github.com/lugosidomotor/jenkins-seed-job-test') // Replace with your repository URL
        // Additional SCM configuration can be added here
    }

    // Build steps
    steps {
        // DSL step to seed Groovy files from '!jobs!' folder
        dsl {
            // Assuming '!jobs!' is a directory in the checked-out repository
            fileFinder('!jobs!/*.groovy') { 
                // Apply DSL script from each found file
                file -> external(file)
            }
        }
    }
}
