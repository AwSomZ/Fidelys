-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  sam. 05 juin 2021 à 15:57
-- Version du serveur :  10.4.6-MariaDB
-- Version de PHP :  7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fidelys`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '(DC2Type:json)',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `username`, `roles`, `password`) VALUES
(1, 'admin', '', '$argon2id$v=19$m=65536,t=4,p=1$Z3VVSEVVQUs1SWs2aXNpRw$95lbW0bDs4Ax/lLY3SIscp2OhCV7S4E6VonAItTN9q4');

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

CREATE TABLE `billet` (
  `id` int(11) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `datealler` date NOT NULL,
  `dateretour` date DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `classe` varchar(255) NOT NULL,
  `adulte` int(11) NOT NULL,
  `jeune` int(11) NOT NULL,
  `enfant` int(11) NOT NULL,
  `bebe` int(11) NOT NULL,
  `dateachat` date NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`id`, `depart`, `destination`, `datealler`, `dateretour`, `type`, `classe`, `adulte`, `jeune`, `enfant`, `bebe`, `dateachat`, `client`, `prix`) VALUES
(1, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', '', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(2, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(3, 'Berlin', 'Abidjan', '2021-04-22', '0000-00-00', 'Aller simple', '', 0, 0, 0, 0, '2021-05-22', '000000002', 0),
(4, 'Bamako', 'Abidjan', '2021-05-22', '0000-00-00', 'Aller simple', 'Classe affaires', 2, 0, 0, 1, '2021-05-22', '000000002', 0),
(5, 'Barcelone', 'Abidjan', '2022-05-22', '2022-05-22', 'Aller retour', 'Classe affaires', 3, 0, 0, 0, '2021-05-22', '000000002', 0),
(6, 'Tunis', 'Abidjan', '2021-05-23', '0000-00-00', 'Aller simple', 'Classe affaires', 2, 0, 0, 0, '2021-05-22', '000000002', 0),
(7, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(8, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(9, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(10, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(11, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(12, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(13, 'Tunis', 'Abidjan', '2021-05-03', '0000-00-00', 'aller', 'affaires', 2, 1, 0, 0, '2021-05-22', '000000002', 0),
(14, 'Abidjan', 'Bamako', '2021-05-22', '0000-00-00', 'Aller simple', 'Classe affaires', 0, 0, 0, 0, '2021-05-22', '000000002', 0),
(15, 'Tunis', 'Abidjan', '2022-05-22', '0000-00-00', 'Aller simple', 'Classe affaires', 3, 0, 0, 0, '2021-05-22', '000000002', 0),
(16, 'Tunis', 'Abidjan', '2022-05-22', '0000-00-00', 'Aller simple', 'Classe affaires', 0, 0, 0, 0, '2021-05-22', '000000002', 0),
(17, 'Tunis', 'Abidjan', '2021-09-24', '0000-00-00', 'Aller simple', 'Classe affaires', 1, 0, 0, 0, '2021-05-24', '000000002', 0),
(18, 'Tunis', 'Abidjan', '2021-05-25', '0000-00-00', 'Aller simple', 'Classe Ã©conomique', 1, 0, 0, 0, '2021-05-24', '000000002', 0),
(19, 'Tunis', 'Abidjan', '2021-05-24', '0000-00-00', 'Aller simple', 'Classe affaires', 1, 0, 0, 0, '2021-05-24', '000000002', 0),
(20, 'Tunis', 'Abidjan', '2021-05-27', '0000-00-00', 'Aller simple', 'Classe affaires', 2, 0, 0, 0, '2021-05-24', '000000002', 0),
(21, 'Tunis', 'Abidjan', '2021-05-25', '0000-00-00', 'Aller simple', 'Classe affaires', 5, 0, 0, 0, '2021-05-24', '000000002', 0),
(22, 'Tunis', 'Abidjan', '2021-05-25', '0000-00-00', 'Aller simple', 'Classe affaires', 0, 0, 0, 0, '2021-05-24', '000000002', 0),
(23, 'Tunis', 'Barcelone', '2021-05-24', '0000-00-00', 'Aller simple', 'Classe affaires', 2, 0, 0, 0, '2021-05-24', '000000002', 5000),
(24, 'Sfax', 'Berlin', '2021-05-24', '0000-00-00', 'Aller simple', 'Classe affaires', 0, 0, 0, 0, '2021-05-24', '000000002', 11000),
(25, 'Tunis', 'Bologne', '2021-05-25', '2021-05-27', 'Aller retour', 'Classe affaires', 0, 0, 0, 0, '2021-05-24', '000000002', 5000),
(26, 'Tunis', 'Berlin', '2021-05-24', '0000-00-00', 'Aller simple', 'Classe affaires', 0, 0, 0, 0, '2021-05-24', '000000002', 11000),
(27, 'Bamako', 'Abidjan', '2021-05-25', '2021-05-26', 'Aller retour', 'Classe affaires', 0, 0, 0, 0, '2021-05-24', '000000002', 0);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` varchar(255) NOT NULL,
  `pin` varchar(255) NOT NULL,
  `cin` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `datenaiss` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `nationalite` varchar(255) NOT NULL,
  `adressedomicile` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `codepostal` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `teldomicile` varchar(255) DEFAULT NULL,
  `telmobile` varchar(255) NOT NULL,
  `societe` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `telprofessionnel` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `langue` varchar(255) NOT NULL,
  `preference` varchar(255) NOT NULL,
  `paiement` varchar(255) NOT NULL,
  `habitude` varchar(255) NOT NULL,
  `classeh` varchar(255) NOT NULL,
  `assistance` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `pin`, `cin`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`, `societe`, `fonction`, `telprofessionnel`, `fax`, `langue`, `preference`, `paiement`, `habitude`, `classeh`, `assistance`, `type`) VALUES
('000000001', '596746501', '55555', 'M', 'update', 'user', '2021-04-24', 'thetaggroupe@gmail.com', 'americain', 'user', 'fzpok', '7979', '65465', '6874684', '68468', 'dfgdg', '', '', '4684', 'Anglais', 'CÃ´tÃ© hublot', 'Cash', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000002', '985764106', '13021112', 'M', 'Tammar', 'mohamed salah', '2016-04-24', 'awsomz21@gmail.com', 'tunisien', 'zhzyzyz', 'ejejej', 'gjfjfj', 'Tuvalu', '', '5656565', '', '', '', '', 'Anglais', 'IndiffÃ©rent', 'ChÃ¨que', 'AccompagnÃ©', 'Business', 'Oui', 'familiale'),
('000000003', '322385204', '1465659', 'M', 'zaghdoudi', 'ines', '2012-03-29', 'awsomz21@gmail.com', 'tunisien', 'fjfjf', 'gjffi', 'tjfjfj', 'Cayman Islands', '565656', '5656565', '', '', '', '', 'Anglais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000004', '869943675', '13021706', 'sdfs', 'aaaezrze', 'fsdf', '2021-02-09', 'awsomz21@gmail.com', 'sdfsdf', 'sfryer', 'dfgdg', 'ytut', 'gfhnf', 'sdfze', 'fsddfsdf', 'gdfgdb', 'jghjt', 'rzerzf', 'vxccv', 'fsdfzer', 'fsdfsdfs', 'fqsfsdf', 'gdgdf', 'bfdgfdg', 'non', 'familiale'),
('000000005', '409210162', '1234567890', 'M', 'created', 'by', '2011-06-05', 'awsomz21@gmail.com', 'fjdh', 'vcc', 'cg', 'hhc', 'Afghanistan', '', '88', '', '', '', '', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Economique', 'Oui', 'individuelle');

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20210525232938', '2021-05-26 01:29:59', 6660),
('DoctrineMigrations\\Version20210527004732', '2021-05-27 02:47:44', 5614),
('DoctrineMigrations\\Version20210602001312', '2021-06-02 02:13:24', 10961);

-- --------------------------------------------------------

--
-- Structure de la table `mouvement`
--

CREATE TABLE `mouvement` (
  `id` int(11) NOT NULL,
  `milesprime` int(11) NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `milesstatut` int(11) NOT NULL,
  `plafond` int(11) NOT NULL DEFAULT 15000,
  `soldecummule` int(11) NOT NULL,
  `date_niveau` date NOT NULL,
  `date_expiration` date NOT NULL,
  `statut` varchar(10) NOT NULL,
  `seuil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mouvement`
--

INSERT INTO `mouvement` (`id`, `milesprime`, `client`, `milesstatut`, `plafond`, `soldecummule`, `date_niveau`, `date_expiration`, `statut`, `seuil`) VALUES
(462, 19000, '000000001', 0, 13000, 0, '0002-11-30', '0000-00-00', '', 0),
(463, 29000, '000000002', 58000, 25000, 20000, '2021-05-03', '2022-05-03', 'gold', 25000),
(464, 9000, '000000003', 0, 15000, 0, '0000-00-00', '0000-00-00', '', 0),
(469, 5000, '000000004', 14000, 25000, 1000, '2021-06-04', '2022-06-04', 'silver', 13000),
(470, 3000, '000000005', 0, 13000, 0, '2021-06-05', '2024-06-05', 'classic', 0);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `datecreation` date NOT NULL,
  `etat` varchar(255) NOT NULL DEFAULT 'en cours',
  `admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id`, `titre`, `description`, `client`, `datecreation`, `etat`, `admin_id`) VALUES
(14, 'faezf', 'sfdfs', '000000002', '2021-05-13', 'resolu', 1),
(15, 'Pin Oublie', 'forgot my pin', '000000002', '2021-06-02', 'resolu', 1);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `credit` int(11) NOT NULL,
  `debit` int(11) NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `credit`, `debit`, `client`, `date`, `description`) VALUES
(62, 1000, 0, '000000002', '2021-05-19', 'Achat des Miles Prime'),
(65, 1000, 0, '000000001', '2021-05-19', 'Achat des Miles Prime comme cadeau'),
(66, 1000, 0, '000000002', '2021-05-19', 'Achat des Miles Prime comme cadeau'),
(67, 1000, 0, '000000002', '2021-05-19', 'Achat des Miles Prime'),
(68, 0, 14555, '000000002', '2021-05-22', 'Achat Billet Prime'),
(69, 0, 0, '000000002', '2021-05-22', 'Achat Billet Prime'),
(70, 0, 0, '000000002', '2021-05-22', 'Achat Billet Prime'),
(71, 0, 0, '000000002', '2021-05-22', 'Achat Billet Prime'),
(72, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(73, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(74, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(75, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(76, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(77, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(78, 0, 5000, '000000002', '2021-05-24', 'Achat Billet Prime'),
(79, 0, 11000, '000000002', '2021-05-24', 'Achat Billet Prime'),
(80, 0, 5000, '000000002', '2021-05-24', 'Achat Billet Prime'),
(81, 1000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(82, 2000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(83, 0, 11000, '000000002', '2021-05-24', 'Achat Billet Prime'),
(84, 0, 0, '000000002', '2021-05-24', 'Achat Billet Prime'),
(85, 1000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(86, 1000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(87, 1000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(88, 1000, 0, '000000002', '2021-05-24', 'Achat des Miles Statut'),
(89, 2000, 0, '000000002', '2021-05-24', 'Achat des Miles Prime'),
(90, 5000, 0, '000000002', '2021-05-25', 'Achat des Miles Statut'),
(91, 5000, 0, '000000002', '2021-05-25', 'Achat des Miles Statut'),
(92, 2000, 0, '000000002', '2021-05-25', 'Achat des Miles Statut'),
(99, 10000, 0, '000000004', '2021-06-04', 'Achat des Miles Statut'),
(100, 3000, 0, '000000004', '2021-06-04', 'Achat des Miles Statut'),
(101, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(102, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(103, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(104, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(105, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(106, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(107, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Prime'),
(108, 1000, 0, '000000002', '2021-06-04', 'Achat des Miles Statut'),
(109, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(110, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(111, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(112, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Statut'),
(113, 1000, 0, '000000003', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(114, 1000, 0, '000000004', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(115, 1000, 0, '000000004', '2021-06-05', 'Achat des Miles Statut comme cadeau'),
(116, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(117, 1000, 0, '000000004', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(118, 4000, 0, '000000001', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(119, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(120, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime'),
(121, 1000, 0, '000000003', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(122, 1000, 0, '000000003', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(124, 1000, 0, '000000001', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(125, 1000, 0, '000000001', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(126, 1000, 0, '000000001', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(130, 1000, 0, '000000001', '2021-06-05', 'Achat des Miles Prime comme cadeau'),
(131, 1000, 0, '000000002', '2021-06-05', 'Achat des Miles Prime');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `datenaiss` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `nationalite` varchar(255) NOT NULL,
  `adressedomicile` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `codepostal` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `teldomicile` varchar(255) DEFAULT NULL,
  `telmobile` varchar(255) NOT NULL,
  `societe` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `telprofessionnel` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `langue` varchar(255) NOT NULL,
  `preference` varchar(255) NOT NULL,
  `paiement` varchar(255) NOT NULL,
  `habitude` varchar(255) NOT NULL,
  `classeh` varchar(255) NOT NULL,
  `assistance` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `vkey` varchar(255) NOT NULL,
  `verified` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`, `societe`, `fonction`, `telprofessionnel`, `fax`, `langue`, `preference`, `paiement`, `habitude`, `classeh`, `assistance`, `type`, `vkey`, `verified`) VALUES
('8523421', 'M', 'zoghlami', 'ridha', '2021-03-08', 'ridha.zoghlami@gmail.com', 'tunisia', 'tunis', 'tunis', '2065', 'tunisie', '71852365', '22765778', 'tu', 'chef dep', '31370146', '123456', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Economique', 'Oui', 'individuelle', '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `user_verification`
--

CREATE TABLE `user_verification` (
  `id` int(11) NOT NULL,
  `token` varchar(5) NOT NULL,
  `dateconfirmation` date DEFAULT NULL,
  `datecreation` date NOT NULL,
  `user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_880E0D76F85E0677` (`username`);

--
-- Index pour la table `billet`
--
ALTER TABLE `billet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client` (`client`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `mouvement`
--
ALTER TABLE `mouvement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client` (`client`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_CE606404642B8210` (`admin_id`),
  ADD KEY `creepar` (`client`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client` (`client`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_verification`
--
ALTER TABLE `user_verification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `billet`
--
ALTER TABLE `billet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `mouvement`
--
ALTER TABLE `mouvement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=471;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT pour la table `user_verification`
--
ALTER TABLE `user_verification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `billet`
--
ALTER TABLE `billet`
  ADD CONSTRAINT `FK_1F034AF6C7440455` FOREIGN KEY (`client`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `mouvement`
--
ALTER TABLE `mouvement`
  ADD CONSTRAINT `FK_5B51FC3EC7440455` FOREIGN KEY (`client`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE606404642B8210` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `FK_CE606404C7440455` FOREIGN KEY (`client`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK_723705D1C7440455` FOREIGN KEY (`client`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `user_verification`
--
ALTER TABLE `user_verification`
  ADD CONSTRAINT `user_verification_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
