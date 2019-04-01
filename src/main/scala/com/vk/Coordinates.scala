package com.vk

final case class Coordinates(x: Int, y: Int) {

  def +(other: Coordinates): Coordinates =
    Coordinates.plus(this, other)

  def moveUp: Coordinates =
    Coordinates.moveUp(this)

  def moveUpBy: Coordinates =
    Coordinates.moveUp(this)

  def moveDown: Coordinates =
    Coordinates.moveDown(this)

  def moveDownBy: Coordinates =
    Coordinates.moveDown(this)

  def moveLeft: Coordinates =
    Coordinates.moveLeft(this)

  def moveLeftBy: Coordinates =
    Coordinates.moveLeft(this)

  def moveRight: Coordinates =
    Coordinates.moveRight(this)

  def moveRightBy: Coordinates =
    Coordinates.moveRight(this)

}

object Coordinates {

  val zero: Coordinates = Coordinates(0, 0)

  val default: Coordinates = Coordinates(10, 10)

  def plus(a: Coordinates, b: Coordinates): Coordinates =
    Coordinates(a.x + b.x, a.y + b.y)

  def moveUp(c: Coordinates): Coordinates =
    c.copy(y = c.y + 1)

  def moveUpBy(c: Coordinates, steps: Int): Coordinates =
    c.copy(y = c.y + steps)

  def moveDown(c: Coordinates): Coordinates =
    c.copy(y = c.y - 1)

  def moveDownBy(c: Coordinates, steps: Int): Coordinates =
    c.copy(y = c.y - steps)

  def moveLeft(c: Coordinates): Coordinates =
    c.copy(x = c.x - 1)

  def moveLeftBy(c: Coordinates, steps: Int): Coordinates =
    c.copy(x = c.x - steps)

  def moveRight(c: Coordinates): Coordinates =
    c.copy(x = c.x + 1)

  def moveRightBy(c: Coordinates, steps: Int): Coordinates =
    c.copy(x = c.x + steps)

}
