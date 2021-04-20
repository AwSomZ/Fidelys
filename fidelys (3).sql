-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 20 avr. 2021 à 04:49
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
('000000001', '596746501', '1343535', 'M', 'tammar', 'mohamed salah', '2012-03-28', 'awsomz21@gmail.com', 'dueyeye', 'ejdhdhd', 'zhzheh', 'rururjr', 'Benin', '656565', '565656', '', '', '', '', 'Anglais', 'CÃ´tÃ© hublot', 'Cash', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000002', '985764106', '123456789', 'M', 'Tammar', 'mohamed salah', '2013-03-29', 'awsomz21@gmail.com', 'tunisien', 'ajzjdj', 'ejejej', 'gjfjfj', 'Tunisia', '', '5656565', '', '', '', '', 'Anglais', 'IndiffÃ©rent', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000003', '322385204', '1465659', 'M', 'zaghdoudi', 'ines', '2012-03-29', 'awsomz21@gmail.com', 'tunisien', 'fjfjf', 'gjffi', 'tjfjfj', 'Cayman Islands', '565656', '5656565', '', '', '', '', 'Anglais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000004', '752799613', '56855', 'M', 'addj', 'ejdjd', '2016-03-29', 'awsomz21@gmail.com', 'gygf', 'yyyfy', 'fuucj', 'jwxyf', 'Afghanistan', '', '864242', '', '', '', '', 'Anglais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Business', 'Oui', 'individuelle');

-- --------------------------------------------------------

--
-- Structure de la table `mouvement`
--

CREATE TABLE `mouvement` (
  `id` int(11) NOT NULL,
  `milesprime` int(11) NOT NULL,
  `client` varchar(255) NOT NULL,
  `milesstatut` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mouvement`
--

INSERT INTO `mouvement` (`id`, `milesprime`, `client`, `milesstatut`) VALUES
(462, 6000, '000000001', 0),
(463, 93000, '000000002', 15000),
(464, 6000, '000000003', 0),
(465, 6000, '000000004', 0);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `credit` int(11) NOT NULL DEFAULT 0,
  `debit` int(11) NOT NULL DEFAULT 0,
  `client` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `credit`, `debit`, `client`, `date`) VALUES
(14, 3000, 0, '000000002', '2021-04-18'),
(15, 6000, 0, '000000002', '2021-04-18'),
(16, 6000, 0, '000000002', '2021-04-18'),
(17, 0, 1000, '000000002', '2021-04-06'),
(18, 0, 2555, '000000002', '2021-04-01'),
(19, 3000, 0, '000000002', '2021-04-18'),
(20, 7000, 0, '000000002', '2021-04-18'),
(21, 3000, 0, '000000002', '2021-04-18'),
(22, 5000, 0, '000000002', '2021-04-18');

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
  `verified` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`, `societe`, `fonction`, `telprofessionnel`, `fax`, `langue`, `preference`, `paiement`, `habitude`, `classeh`, `assistance`, `type`, `vkey`, `verified`) VALUES
('8523421', 'M', 'zoghlami', 'ridha', '2021-03-08', 'ridha.zoghlami@gmail.com', 'tunisia', 'tunis', 'tunis', '2065', 'tunisie', '71852365', '22765778', 'tu', 'chef dep', '31370146', '123456', 'Francais', 'CÃ´tÃ© hublot', 'Carte de crÃ©dit', 'Seul', 'Economique', 'Oui', 'individuelle', '', 0);

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `client` (`client`);

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
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `mouvement`
--
ALTER TABLE `mouvement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=466;

--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `mouvement`
--
ALTER TABLE `mouvement`
  ADD CONSTRAINT `mouvement_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
