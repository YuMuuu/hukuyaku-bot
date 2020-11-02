package com.serviveragent

import com.jagrosh.jdautilities.command.{Command, CommandClient, CommandClientBuilder}
import com.serviveragent.command.{HelloCommand, HukuyakuCommand}
import com.serviveragent.config.ServiceConfig
import com.serviveragent.usecase.HukuyakuUseCase
import net.dv8tion.jda.api.{AccountType, JDA, JDABuilder, OnlineStatus}
import net.dv8tion.jda.api.entities.Activity
import com.softwaremill.macwire._
import com.typesafe.config.ConfigFactory
import pureconfig._
import pureconfig.generic.auto._
import sun.reflect.generics.reflectiveObjects.NotImplementedException

trait AppModules {
  val conf: ServiceConfig = ConfigSource.default.loadOrThrow[ServiceConfig]
  lazy val token: String = conf.token
  lazy val ownerId: String =conf.ownerId

//  lazy val COMMAND_PREFIX: String = "!" // コマンドの接頭辞
  lazy val activity: Activity = Activity.playing("hukuyaku-bot2")



  lazy val hukuyakuUseCase: HukuyakuUseCase = wire[HukuyakuUseCase]

  lazy val helloCommand: Command = wire[HelloCommand]
  lazy val hukuyakuCommand: Command = wire[HukuyakuCommand]


  val commandClient: CommandClient = new CommandClientBuilder()
    .setStatus(OnlineStatus.ONLINE)
    .setActivity(activity)
    .setOwnerId(ownerId)

    .addCommand(helloCommand)
    .addCommand(hukuyakuCommand)
    .build()

  val jda: JDA = new JDABuilder(AccountType.BOT)
    .setToken(token)
    .addEventListeners(commandClient)
    .build()
}
