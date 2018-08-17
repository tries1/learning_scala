package models

import java.util.Date

case class Computer (id: Option[Long] = None, name: String, introduced: Option[Date], discontinued: Option[Date], companyId: Option[Long])