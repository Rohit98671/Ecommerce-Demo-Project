/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     5/21/2020 6:26:10 PM                         */
/*==============================================================*/



drop table if exists AccountLinked;

drop table if exists Address;

drop table if exists BankDetails;

drop table if exists "Order";

drop table if exists OrderDetails;

drop table if exists Product;

drop table if exists Rating;

drop table if exists ShippingDetails;

drop table if exists ShoppingCart;

drop table if exists TopSales;

drop table if exists User;

drop table if exists WishList;

drop table if exists becomes;

/*==============================================================*/
/* Table: AccountLinked                                         */
/*==============================================================*/
create table AccountLinked
(
   accLinkID            bigint not null  comment '',
   id                   bigint  comment '',
   AccName              varchar(20) not null  comment '',
   primary key (accLinkID)
);

/*==============================================================*/
/* Table: Address                                               */
/*==============================================================*/
create table Address
(
   addID                bigint not null  comment '',
   id                   bigint  comment '',
   City                 varchar(20) not null  comment '',
   District             varchar(20) not null  comment '',
   State                varchar(20) not null  comment '',
   ZipCode              varchar(10) not null  comment '',
   primary key (addID)
);

/*==============================================================*/
/* Table: BankDetails                                           */
/*==============================================================*/
create table BankDetails
(
   CardNo               varchar(20) not null  comment '',
   PinCode              varchar(20) not null  comment '',
   BankDetailsID        bigint not null  comment '',
   accLinkID            bigint  comment '',
   primary key (BankDetailsID)
);

/*==============================================================*/
/* Table: "Order"                                               */
/*==============================================================*/
create table "Order"
(
   ordID                bigint not null  comment '',
   oderDetailsID        bigint  comment '',
   shpID                varchar(20)  comment '',
   id                   bigint  comment '',
   odTime               time not null  comment '',
   odDate               date not null  comment '',
   ShpAmt               decimal(10,2) not null  comment '',
   ProdAmt              decimal(10,2) not null  comment '',
   primary key (ordID)
);

/*==============================================================*/
/* Table: OrderDetails                                          */
/*==============================================================*/
create table OrderDetails
(
   quant                bigint not null  comment '',
   totalAmt             decimal(20,2) not null  comment '',
   oderDetailsID        bigint not null  comment '',
   ordID                bigint  comment '',
   primary key (oderDetailsID)
);

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   prodID               bigint not null  comment '',
   WishListID           bigint  comment '',
   cartID               varchar(20)  comment '',
   RatingsID            bigint  comment '',
   oderDetailsID        bigint  comment '',
   prodName             varchar(20) not null  comment '',
   prodPrice            decimal(20,2) not null  comment '',
   comment              varchar(500)  comment '',
   stats                varchar(20) not null  comment '',
   prodImg              longblob  comment '',
   Description          varchar(500)  comment '',
   primary key (prodID)
);

/*==============================================================*/
/* Table: Rating                                                */
/*==============================================================*/
create table Rating
(
   ratingPoint          int  comment '',
   RatingsID            bigint not null  comment '',
   prodID               bigint  comment '',
   primary key (RatingsID)
);

/*==============================================================*/
/* Table: ShippingDetails                                       */
/*==============================================================*/
create table ShippingDetails
(
   shpID                varchar(20) not null  comment '',
   addID                bigint  comment '',
   sName                varchar(20) not null  comment '',
   shpAddress           varchar(20) not null  comment '',
   shpDate              datetime not null  comment '',
   phNum                varchar(20) not null  comment '',
   primary key (shpID)
);

/*==============================================================*/
/* Table: ShoppingCart                                          */
/*==============================================================*/
create table ShoppingCart
(
   cartID               varchar(20) not null  comment '',
   cartDate             datetime not null  comment '',
   cartQuant            int not null  comment '',
   cartTotalprice       decimal(20,2) not null  comment '',
   primary key (cartID)
);

/*==============================================================*/
/* Table: TopSales                                              */
/*==============================================================*/
create table TopSales
(
   offerPrice           decimal(20,2) not null  comment '',
   salesDesc            varchar(500)  comment '',
   startDate            datetime not null  comment '',
   EndDate              datetime not null  comment '',
   SalesID              bigint not null  comment '',
   primary key (SalesID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   bigint not null  comment '',
   WishListID           bigint  comment '',
   username             varchar(20) not null  comment '',
   Password             varchar(20) not null  comment '',
   fName                varchar(50) not null  comment '',
   lName                varchar(50) not null  comment '',
   contactNum           varchar(20) not null  comment '',
   Gender               varchar(20) not null  comment '',
   primary key (id)
);

/*==============================================================*/
/* Table: WishList                                              */
/*==============================================================*/
create table WishList
(
   addDate              datetime not null  comment '',
   WishListID           bigint not null  comment '',
   id                   bigint  comment '',
   primary key (WishListID)
);

/*==============================================================*/
/* Table: becomes                                               */
/*==============================================================*/
create table becomes
(
   prodID               bigint not null  comment '',
   SalesID              bigint not null  comment '',
   primary key (prodID, SalesID)
);


