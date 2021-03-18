-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 18 mars 2021 à 23:46
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
  `teldomicile` varchar(255) NOT NULL,
  `telmobile` varchar(255) NOT NULL,
  `societe` varchar(255) NOT NULL,
  `fonction` varchar(255) NOT NULL,
  `telprofessionnel` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
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
('123456', '1234', '13021706', 'm', 'gfdgd', 'gdgd', '2021-03-18', 'awsomz@gmail.com', 'fhfh', 'fghfh', 'fhghf', 'hfghf', 'hfhgf', '25345', '353563', 'gfhfh', 'jytujt', '6954254', '5772', 'fr', 'gfdg', 'gdfgd', 'gdgd', 'gdgd', 'gdfgd', 'gdfgd');

-- --------------------------------------------------------

--
-- Structure de la table `mouvement`
--

CREATE TABLE `mouvement` (
  `identifiant` varchar(255) NOT NULL,
  `solde` int(11) NOT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `teldomicile` varchar(255) NOT NULL,
  `telmobile` varchar(255) NOT NULL,
  `societe` varchar(255) NOT NULL,
  `fonction` varchar(255) NOT NULL,
  `telprofessionnel` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
  `langue` varchar(255) NOT NULL,
  `preference` varchar(255) NOT NULL,
  `paiement` varchar(255) NOT NULL,
  `habitude` varchar(255) NOT NULL,
  `classeh` varchar(255) NOT NULL,
  `assistance` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`, `societe`, `fonction`, `telprofessionnel`, `fax`, `langue`, `preference`, `paiement`, `habitude`, `classeh`, `assistance`, `type`) VALUES
('123', 'fsdf', 'fsdf', 'fsdf', '2021-02-02', 'fss', 'fsfs', 'fsdf', 'fsdf', 'fsdfs', 'fsfd', 'fs', 'fsdf', 'fsdf', 'gdfg', 'gdfg', 'tert', 'rzer', 'sfq', 'fsdg', 'jhgjgb', 'nvbnv', 'hfhf', 'rt'),
('164656', 'M', 'test', 'test', '2021-03-08', 'awsomz@g.com', 'rjfjrjoo', 'rjrjejej2i', 'fjrjeuei', 'rjjrjrfjjd', 'rjfjfjfj', '6565656', '565656', 'ueueueu', 'uiurjf', '6565665', '1656865', 'Anglais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'AccompagnÃ©', 'Business', 'Oui', 'individuelle'),
('434343', 'M', 'djdjdj', 'jdjfj', '2021-03-08', 'e@gm.com', 'fyufugufufu', 'yyfufu', 'rufuf', 'dufudu', 'fufueueu', '53535', '566565', 'yeye', 'zuaya', '868653', '135353', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Economique', 'Oui', 'individuelle'),
('4646464', 'M', 'zkejdk', 'ffjfjf', '2021-03-08', 'ziziii@g.com', 'ejdjzjzjz', 'rttr', 'euzuzuz', 'djejzjzje', 'djfkfkf', '56565', '56464', 'djdjsjzjz', 'eieieie', '4656565', '464646464', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle'),
('534356', 'M', 'zueueu', 'ufufueu', '2021-03-08', '37e7@g.com', 'fueueu', 'dueueu', 'rufufu', 'fjfufu', 'fjfufu', '564646', '5656566', 'dududu', 'dydysy', '646565', '5646464', 'Anglais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle'),
('8523421', 'M', 'zoghlami', 'ridha', '2021-03-08', 'ridha.zoghlami@gmail.com', 'tunisia', 'tunis', 'tunis', '2065', 'tunisie', '71852365', '22765778', 'tu', 'chef dep', '31370146', '123456', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Economique', 'Oui', 'individuelle');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mouvement`
--
ALTER TABLE `mouvement`
  ADD PRIMARY KEY (`identifiant`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
