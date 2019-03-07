package com.vk

import com.vk.Rover.{Coordinates, Direction, Position, moveForward}

object GridTest extends App{

  def testing(p: Position) = {

    val steps = 10

    steps match {

      case num =>
        if (p.direction == Direction("n")) {

          if (num <= 10) {
            val newCoordinates = Coordinates(0, num)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {
            val newCoordinates = Coordinates(0, num - 10)
            val newPosition = Position(newCoordinates, p.direction)
            println("position" + newPosition)
          }

        } else if (p.direction == Direction("s")) {

          if (num <= 10) {
            val newCoordinates = Coordinates(0, -num)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {
            val newCoordinates = Coordinates(0, -10-num)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          }

        } else if (p.direction == Direction("w")) {

          if (num <= 10) {

            val newCoordinates = Coordinates(-num, 0)
            val newPosition = Position(newCoordinates, p.direction)
            println(newPosition)
            newPosition
          } else {
            val newCoordinates = Coordinates(-10-num, 0)
            val newPosition = Position(newCoordinates, p.direction)
            println(newPosition)
            newPosition
          }

        } else {

          if (num <= 10) {
            val newCoordinates = Coordinates(num, 0)
            val newPosition = Position(newCoordinates, p.direction)
            println(newPosition)
            newPosition
          } else {
            val newCoordinates = Coordinates(num-10, 0)
            val newPosition = Position(newCoordinates, p.direction)
            println(newPosition)
            newPosition
          }
        }

      case _ =>
        moveForward(steps, p)
    }
  }
  testing(Position(Coordinates(11, 1), Direction("n")))
}
