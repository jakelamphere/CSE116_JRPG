package tests

import org.scalatest._
import jrpg.Character

class testsCharacter extends FunSuite {
  test("test") {
    val char1: Character = new Character(50, 50, 50, 50, 50, 50, 50, 50)
    val char2: Character = new Character(100, 100, 100, 100, 100, 100, 100, 100)
    char1.takeDamage(50)
    char2.takeDamage(99)

    assert(!char1.alive)
    assert(char2.currHP == 1)

    val char3: Character = new Character(50, 50, 50, 50, 50, 50, 50, 50)
    val char4: Character = new Character(50, 50, 50, 50, 50, 50, 50, 50)
    val char5: Character = new Character(50, 50, 50, 50, 50, 50, 50, 50)

    char3.physAttack(char4)

    assert(char3.expPoints == 0)

    char3.magAttack(char4)

    assert(char3.expPoints == 10)

    char5.expPoints = 205
    char5.increaseLevel()

    assert(char5.playerLevel == 3)
    assert(char5.expPoints == 5)
    assert(char5.Att == 70)



  }
}
