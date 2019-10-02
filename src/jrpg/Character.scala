package jrpg

class Character(var Att: Int, var Def: Int, var MagAtt: Int, var MagDef: Int, var maxHP: Int, var currHP: Int, var maxMP: Int, var currMP: Int) {
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
}
