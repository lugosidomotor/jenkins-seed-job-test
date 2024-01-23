## Install Jenkins
```bash
sudo docker run -p 8080:8080 -p 50000:50000 --restart=on-failure jenkins/jenkins:lts-jdk17
```
## Create Job DSL for Seed job

1. Create new freestyle job
2. Build Steps > Process Job DSLs
3. Add the following code:
```bash
job('Job_DSL_Seed') {
  scm {
    git {
      remote {
        url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
      }
    }
  }
  steps {
    jobDsl {
      targets '*.groovy'
    }
  }
}
```
3. Approve script in Dashboard > Manage Jenkins > ScriptApproval
4. Press 'Build Now'
