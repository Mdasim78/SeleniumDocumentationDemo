pipeline{
	agent any
	
	stages{
		stage('build'){
			steps{
				echo "this is printed in all allowed branches"
			}
		}
		
		stage('fix-branch-specific'){
			when{
				branch 'fix-*'
			}
			steps{
					echo "this is printed in all branches that starts with fix-" 
				
			}
		}
		
	}
}