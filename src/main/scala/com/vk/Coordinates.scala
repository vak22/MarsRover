package com.vk

final case class Coordinates(x: Int, y: Int) {

  def +(other: Coordinates): Coordinates =
    Coordinates.plus(this, other)

  def moveUp: Coordinates =
    Coordinates.moveUp(this)

  def moveDown: Coordinates =
    Coordinates.moveDown(this)

  def moveLeft: Coordinates =
    Coordinates.moveLeft(this)

  def moveRight: Coordinates =
    Coordinates.moveRight(this)

}

object Coordinates {

  val zero: Coordinates = Coordinates(0, 0)

  def plus(a: Coordinates, b: Coordinates): Coordinates =
    Coordinates(a.x + b.x, a.y + b.y)

  def moveUp(c: Coordinates): Coordinates =
    c.copy(y = c.y + 1)

  def moveDown(c: Coordinates): Coordinates =
    c.copy(y = c.y - 1)

  def moveLeft(c: Coordinates): Coordinates =
    c.copy(x = c.x - 1)

  def moveRight(c: Coordinates): Coordinates =
    c.copy(x = c.x + 1)

}
