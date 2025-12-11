import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2024.03"

project {

    val N = 10 //number of VCS roots

    for (i in 1..N) {

        vcsRoot(GitVcsRoot({
            id("GitRoot_$i") 
            name = "Git Root #$i"
            url = "https://github.com/ChubatovaTiger/manyBranches"
            branch = "refs/heads/br-demo$i"   
           })
        )
    }
}



