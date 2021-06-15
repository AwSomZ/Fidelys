-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 16 juin 2021 à 00:51
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
  `datealler` datetime NOT NULL,
  `dateretour` datetime DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `classe` varchar(255) NOT NULL,
  `dateachat` datetime NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`id`, `depart`, `destination`, `datealler`, `dateretour`, `type`, `classe`, `dateachat`, `client`, `prix`) VALUES
(47, 'Tunis', 'Amsterdam', '2021-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:01:18', '000000008', 11000),
(48, 'Tunis', 'Barcelone', '2021-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:02:39', '000000008', 5000),
(49, 'Tunis', 'Istanbul', '2021-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:06:24', '000000008', 10000),
(50, 'Tunis', 'BÃ¢le', '2022-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:07:15', '000000008', 7000),
(51, 'Tunis', 'Beyrouth', '2021-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:08:25', '000000008', 14000),
(52, 'Tunis', 'Bamako', '2021-06-14 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-14 22:15:47', '000000008', 20000),
(53, 'Tunis', 'Abidjan', '2021-05-03 00:00:00', '2021-05-04 10:00:00', 'aller', 'affaires', '2021-06-15 01:42:44', '000000002', 1),
(54, 'Tunis', 'BÃ¢le', '2021-06-18 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 01:47:51', '000000002', 7000),
(55, 'Tunis', 'Barcelone', '2021-06-15 00:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 01:49:03', '000000002', 5000),
(56, 'Tunis', 'Barcelone', '2021-06-19 03:00:00', '2021-06-17 01:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 02:04:08', '000000002', 5000),
(57, 'Tunis', 'Belgrade', '2021-06-15 06:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 15:12:48', '000000002', 8000),
(58, 'Tunis', 'Belgrade', '2021-06-15 06:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 15:12:58', '000000002', 8000),
(59, 'Tunis', 'Belgrade', '2021-06-18 02:00:00', '2021-06-19 00:00:00', 'Aller retour', 'Classe affaires', '2021-06-15 15:46:18', '000000002', 8000),
(60, 'Tunis', 'Belgrade', '2021-06-18 02:00:00', '2021-06-19 00:00:00', 'Aller retour', 'Classe affaires', '2021-06-15 15:46:48', '000000002', 8000),
(61, 'Tunis', 'Belgrade', '2021-06-18 02:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 15:47:06', '000000002', 8000),
(62, 'Tunis', 'Belgrade', '2021-06-18 02:00:00', '0000-00-00 00:00:00', 'Aller simple', 'Classe affaires', '2021-06-15 15:54:20', '000000002', 8000),
(63, 'Tunis', 'BÃ¢le', '2021-06-15 01:00:00', '2021-06-15 02:00:00', 'Aller retour', 'Classe affaires', '2021-06-15 15:55:18', '000000002', 7000);

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
  `telmobile` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `pin`, `cin`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`) VALUES
('000000001', '596746501', '55555', 'M', 'update', 'user', '2021-04-24', 'thetaggroupe@gmail.com', 'americain', 'user', 'fzpok', '7979', '65465', '6874684', '68468'),
('000000002', '985764106', '13021112', 'M', 'Tammar', 'mohamed salah', '2016-04-24', 'awsomz21@gmail.com', 'tunisien', 'monome wardia', 'tunis', '1009', 'Tunisia', '', '99657651'),
('000000003', '322385204', '1465659', 'M', 'zaghdoudi', 'ines', '2012-03-29', 'awsomz21@gmail.com', 'tunisien', 'fjfjf', 'gjffi', 'tjfjfj', 'Cayman Islands', '565656', '5656565'),
('000000004', '869943675', '13021706', 'sdfs', 'aaaezrze', 'fsdf', '2021-02-09', 'awsomz21@gmail.com', 'sdfsdf', 'sfryer', 'dfgdg', 'ytut', 'gfhnf', 'sdfze', 'fsddfsdf'),
('000000005', '409210162', '1234567890', 'M', 'created', 'by', '2011-06-05', 'awsomz21@gmail.com', 'fjdh', 'vcc', 'cg', 'hhc', 'Afghanistan', '', '88'),
('000000006', '220034424', '15666', 'M', 'tammar', 'mohamed salah', '2018-06-12', 'awsomz21@gmail.com', 'tunisian', 'jjejdjd', 'djsjdjdje', 'djdjdjdjdj', 'Tunisia', '494646464', '494946464'),
('000000007', '900256456', '132949', 'M', 'last', 'test', '2009-06-13', 'awsomz21@gmail.com', 'zjzhz', 'djdjj', 'duehz', 'djdjej', 'Afghanistan', '6464616', '949494'),
('000000008', '508050462', '6558', 'M', 'shsh', 'ejddj', '2008-06-14', 'awsomz21@gmail.com', 'hhy', 'ytt', 'hhhy', 'hhy', 'Afghanistan', '9685', '966'),
('000000009', '600943167', '56566', 'M', 'ines', 'djdj', '2005-06-15', 'awsomz21@gmail.com', 'heyehz', 'eyzy', 'dhzhz', 'euehe', 'Andorra', '4949', '46464');

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
(463, 5999, '000000002', 59000, 25000, 21000, '2021-05-03', '2022-05-03', 'gold', 25000),
(464, 9000, '000000003', 0, 15000, 0, '0000-00-00', '0000-00-00', '', 0),
(469, 5000, '000000004', 14000, 25000, 1000, '2021-06-04', '2022-06-04', 'silver', 13000),
(470, 3000, '000000005', 0, 13000, 0, '2021-06-05', '2024-06-05', 'classic', 0),
(471, 3000, '000000006', 14000, 25000, 1000, '2021-06-12', '2022-06-12', 'silver', 13000),
(472, 4000, '000000007', 0, 13000, 0, '2021-06-13', '2024-06-13', 'classic', 0),
(473, 20000, '000000008', 0, 13000, 0, '2021-06-14', '2024-06-14', 'classic', 0),
(474, 3000, '000000009', 0, 15000, 0, '2021-06-15', '2024-06-15', 'classic', 0);

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
(30, 'Code Pin Oublie', 'j ai oublie mon code pin', '000000002', '2021-06-15', 'resolu', 1),
(31, 'Demande de duplication du carte', 'je veux dupliquer ma carte', '000000002', '2021-06-15', 'en cours', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `montant` int(11) NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `type`, `montant`, `client`, `date`, `description`) VALUES
(160, 'credit', 1000, '000000002', '2021-06-14 01:20:33', 'Achat des Miles Prime'),
(161, 'credit', 1000, '000000002', '2021-06-14 01:20:50', 'Achat des Miles Prime'),
(162, 'credit', 1000, '000000002', '2021-06-14 01:23:20', 'Achat des Miles Prime'),
(163, 'credit', 4000, '000000002', '2021-06-14 01:23:58', 'Achat des Miles Prime'),
(164, 'credit', 1000, '000000002', '2021-06-14 13:24:32', 'Achat des Miles Prime'),
(165, 'debit', 5000, '000000002', '2021-06-14 13:25:53', 'Achat Billet Prime'),
(166, 'credit', 8000, '000000002', '2021-06-14 13:42:01', 'Achat des Miles Prime'),
(167, 'debit', 5000, '000000002', '2021-06-14 13:43:19', 'Achat Billet Prime'),
(168, 'credit', 1000, '000000008', '2021-06-14 13:53:25', 'Achat des Miles Prime'),
(169, 'credit', 10000, '000000008', '2021-06-14 20:58:25', 'Achat des Miles Prime'),
(170, 'debit', 7000, '000000008', '2021-06-14 20:58:57', 'Achat Billet Prime'),
(171, 'debit', 7000, '000000008', '2021-06-14 20:59:34', 'Achat Billet Prime'),
(172, 'credit', 10000, '000000008', '2021-06-14 21:05:53', 'Achat des Miles Prime'),
(173, 'debit', 7000, '000000008', '2021-06-14 21:06:33', 'Achat Billet Prime'),
(174, 'credit', 10000, '000000008', '2021-06-14 21:07:47', 'Achat des Miles Prime'),
(175, 'debit', 11000, '000000008', '2021-06-14 21:08:34', 'Achat Billet Prime'),
(176, 'credit', 10000, '000000008', '2021-06-14 21:22:38', 'Achat des Miles Prime'),
(177, 'debit', 11000, '000000008', '2021-06-14 21:23:22', 'Achat Billet Prime'),
(178, 'credit', 10000, '000000008', '2021-06-14 21:25:26', 'Achat des Miles Prime'),
(179, 'debit', 7000, '000000008', '2021-06-14 21:25:44', 'Achat Billet Prime'),
(180, 'credit', 1000, '000000008', '2021-06-14 21:27:18', 'Achat des Miles Prime'),
(181, 'credit', 10000, '000000008', '2021-06-14 21:27:23', 'Achat des Miles Prime'),
(182, 'debit', 7000, '000000008', '2021-06-14 21:27:56', 'Achat Billet Prime'),
(183, 'debit', 7000, '000000008', '2021-06-14 21:35:34', 'Achat Billet Prime'),
(184, 'credit', 10000, '000000008', '2021-06-14 21:56:07', 'Achat des Miles Prime'),
(185, 'debit', 7000, '000000008', '2021-06-14 21:56:33', 'Achat Billet Prime'),
(186, 'credit', 10000, '000000008', '2021-06-14 21:58:43', 'Achat des Miles Prime'),
(187, 'debit', 7000, '000000008', '2021-06-14 21:59:34', 'Achat Billet Prime'),
(188, 'credit', 10000, '000000008', '2021-06-14 22:00:56', 'Achat des Miles Prime'),
(189, 'debit', 11000, '000000008', '2021-06-14 22:01:18', 'Achat Billet Prime'),
(190, 'debit', 5000, '000000008', '2021-06-14 22:02:39', 'Achat Billet Prime'),
(191, 'credit', 10000, '000000008', '2021-06-14 22:05:28', 'Achat des Miles Prime'),
(192, 'debit', 10000, '000000008', '2021-06-14 22:06:24', 'Achat Billet Prime'),
(193, 'credit', 10000, '000000008', '2021-06-14 22:06:57', 'Achat des Miles Prime'),
(194, 'debit', 7000, '000000008', '2021-06-14 22:07:15', 'Achat Billet Prime'),
(195, 'credit', 10000, '000000008', '2021-06-14 22:08:06', 'Achat des Miles Prime'),
(196, 'debit', 14000, '000000008', '2021-06-14 22:08:25', 'Achat Billet Prime'),
(197, 'credit', 10000, '000000008', '2021-06-14 22:15:04', 'Achat des Miles Prime'),
(198, 'credit', 10000, '000000008', '2021-06-14 22:15:07', 'Achat des Miles Prime'),
(199, 'debit', 20000, '000000008', '2021-06-14 22:15:47', 'Achat Billet Prime'),
(200, 'credit', 10000, '000000008', '2021-06-14 22:17:20', 'Achat des Miles Prime'),
(201, 'credit', 10000, '000000008', '2021-06-14 22:17:23', 'Achat des Miles Prime'),
(202, 'debit', 1, '000000002', '2021-06-15 01:42:44', 'Achat Billet Prime'),
(203, 'debit', 7000, '000000002', '2021-06-15 01:47:51', 'Achat Billet Prime'),
(204, 'credit', 10000, '000000002', '2021-06-15 01:48:34', 'Achat des Miles Prime'),
(205, 'debit', 5000, '000000002', '2021-06-15 01:49:03', 'Achat Billet Prime'),
(206, 'debit', 5000, '000000002', '2021-06-15 02:04:08', 'Achat Billet Prime'),
(207, 'credit', 10000, '000000002', '2021-06-15 02:07:47', 'Achat des Miles Prime'),
(208, 'credit', 10000, '000000002', '2021-06-15 02:07:49', 'Achat des Miles Prime'),
(209, 'debit', 8000, '000000002', '2021-06-15 15:12:48', 'Achat Billet Prime'),
(210, 'debit', 8000, '000000002', '2021-06-15 15:12:58', 'Achat Billet Prime'),
(211, 'credit', 10000, '000000002', '2021-06-15 15:37:06', 'Achat des Miles Prime'),
(212, 'credit', 10000, '000000002', '2021-06-15 15:37:13', 'Achat des Miles Prime'),
(213, 'debit', 8000, '000000002', '2021-06-15 15:46:18', 'Achat Billet Prime'),
(214, 'debit', 8000, '000000002', '2021-06-15 15:46:48', 'Achat Billet Prime'),
(215, 'debit', 8000, '000000002', '2021-06-15 15:47:06', 'Achat Billet Prime'),
(216, 'debit', 8000, '000000002', '2021-06-15 15:54:20', 'Achat Billet Prime'),
(217, 'debit', 7000, '000000002', '2021-06-15 15:55:18', 'Achat Billet Prime'),
(218, 'credit', 10000, '000000002', '2021-06-15 15:58:18', 'Achat des Miles Prime'),
(219, 'credit', 10000, '000000002', '2021-06-15 15:58:20', 'Achat des Miles Prime');

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
  `telmobile` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`) VALUES
('1234567890', 'M', 'zaghdoudi', 'ines', '1999-06-10', 'awsomz21@gmail.com', 'tunisienne', 'bardo khaznadar', 'tunis', '1004', 'Tunisia', '71656536', '94656133'),
('8523421', 'M', 'zoghlami', 'ridha', '2021-03-08', 'ridha.zoghlami@gmail.com', 'tunisia', 'tunis', 'tunis', '2065', 'tunisie', '71852365', '22765778');

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
-- Déchargement des données de la table `user_verification`
--

INSERT INTO `user_verification` (`id`, `token`, `dateconfirmation`, `datecreation`, `user`) VALUES
(11, 'cb207', NULL, '2021-06-15', '1234567890'),
(12, '7960f', NULL, '2021-06-15', '1234567890'),
(13, 'f6f02', NULL, '2021-06-15', '1234567890');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT pour la table `mouvement`
--
ALTER TABLE `mouvement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=475;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;

--
-- AUTO_INCREMENT pour la table `user_verification`
--
ALTER TABLE `user_verification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

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
