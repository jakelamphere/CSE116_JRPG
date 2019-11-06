package jrpg

abstract class Character(var Att: Int, var Def: Int, var MagAtt: Int, var MagDef: Int, var maxHP: Int, var currHP: Int, var maxMP: Int, var currMP: Int) {
  def initialStats(): Unit = {
    Att = 0
    Def = 0
    MagAtt = 0
    MagDef = 0
    maxHP = 0
    currHP = 0
    maxMP = 0
    currMP = 0
  }
  var alive = true
  var expPoints: Int = 0
  var playerLevel: Int = 1
  def increaseLevel(): Unit = {
    if(expPoints >= 100){
      playerLevel += 1
      expPoints -= 100
      Att += 10
      Def += 10
      MagAtt += 10
      MagDef += 10
      currHP = maxHP
    }
    else{
      playerLevel = playerLevel
    }
    if(expPoints >= 100){
      increaseLevel()
    }
    else{}
  }
  def takeDamage(damage: Int) : Unit = {
    currHP -= damage
    if(currHP <= 0){
      alive = false
      currHP = 0
    }
    else{
      alive = true
    }
  }
  def physAttack(defPlayer: Character): Unit = {
    val netAtt: Int = (Att - (defPlayer.Def / 10))
    defPlayer.takeDamage(netAtt)
    if(!defPlayer.alive){
      expPoints += (defPlayer.playerLevel * 10)
    }
    else{
      expPoints = expPoints
    }
    increaseLevel()
  }
  def magAttack(defPlayer: Character): Unit = {
    if(currMP >= 10){
      val netAtt = MagAtt - (defPlayer.MagDef / 10)
      currMP -= 10
      defPlayer.takeDamage(netAtt)
    }
    if(!defPlayer.alive){
      expPoints += (defPlayer.playerLevel * 10)
    }
    else{
      expPoints = expPoints
    }
    increaseLevel()
  }
  def battleOptions(): List[String] = {
    val list: List[String] = List()
    list
  }
  def takeAction(battleAction: String, character: Character): Unit = {
    val list: List[String] = battleOptions()
    if(list.contains(battleAction)){
    }
    else{
    }
  }
  def Smash(defPlayer: Character): Unit = {
    val netAtt: Int = (Att - (defPlayer.Def / 10))
    defPlayer.takeDamage(netAtt)
    if(!defPlayer.alive){
      expPoints += (defPlayer.playerLevel * 10)
    }
    else{
      expPoints = expPoints
    }
    increaseLevel()
  }
}
