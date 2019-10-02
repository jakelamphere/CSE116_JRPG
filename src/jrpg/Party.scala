package jrpg

class Party(party: List[Character]) {
  val par: List[Character] = party
  def expGain(partie: Party): Unit ={
    var totalPoints: Int = 0
    for(char <- partie.par){
      totalPoints += (char.playerLevel * 10)
    }
    val liveWinningParty: List[Character] = List()
    for(char <- party){
      if(char.alive){
        liveWinningParty :+ char
      }
      else{

      }
    }
    var eachPoints = totalPoints / liveWinningParty.length
    for(char <- party){
      char.expPoints += eachPoints
    }
  }
}
