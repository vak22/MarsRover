package com.vk

sealed trait Direction

object Direction {
  case object North extends Direction
  case object South extends Direction
  case object East extends Direction
  case object West extends Direction

  def rotateClockwise(d: Direction): Direction =
    d match {
      case North => East
      case East  => South
      case South => West
      case West  => North
    }

  def rotateAntiClockwise(d: Direction): Direction =
    d match {
      case North => West
      case East  => North
      case South => East
      case West  => South
    }
}
