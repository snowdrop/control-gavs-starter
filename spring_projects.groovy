final url = "https://gist.githubusercontent.com/cmoulliard/1457fdd3fc505a5e1f9878e8f842365a/raw/756a141c68169f8dcc6c55e8eece9119c6769012/gistfile1.txt".toURL()
final text = url.text

final File projectsFile = new File("generated/spring_projects.txt")

text
  .split( '\n' )
  .findAll { it.contains( '!' ) }
  .collect {
    final index = it.indexOf('!')
    return it.substring(index + 1)
  }
  .unique()
  .sort()
  .findAll { it.contains('springframework') }
  .each { projectsFile << ("${it}\n") }
