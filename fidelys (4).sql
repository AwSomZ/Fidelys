-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 06 mai 2021 à 04:16
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
('000000001', '596746501', '55555', 'M', 'update', 'user', '2021-04-24', 'thetaggroupe@gmail.com', 'americain', 'user', 'fzpok', '7979', '65465', '6874684', '68468', 'dfgdg', '', '', '4684', 'Anglais', 'CÃ´tÃ© hublot', 'Cash', 'Seul', 'Business', 'Oui', 'individuelle'),
('000000002', '985764106', '13021112', 'M', 'Tammarr', 'mohamed salah', '2016-04-24', 'awsomz21@gmail.com', 'tunisien', 'zhzyzyz', 'ejejej', 'gjfjfj', 'Tuvalu', '', '5656565', '', '', '', '', 'Anglais', 'IndiffÃ©rent', 'ChÃ¨que', 'AccompagnÃ©', 'Business', 'Oui', 'familiale'),
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
  `milesstatut` int(11) NOT NULL DEFAULT 0,
  `plafond` int(11) NOT NULL DEFAULT 15000,
  `soldecummule` int(11) NOT NULL DEFAULT 0,
  `date_niveau` date NOT NULL,
  `date_expiration` date NOT NULL,
  `statut` varchar(10) NOT NULL,
  `seuil` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mouvement`
--

INSERT INTO `mouvement` (`id`, `milesprime`, `client`, `milesstatut`, `plafond`, `soldecummule`, `date_niveau`, `date_expiration`, `statut`, `seuil`) VALUES
(462, 6000, '000000001', 0, 15000, 0, '0000-00-00', '0000-00-00', '', 0),
(463, 24000, '000000002', 41000, 25000, 3000, '2021-05-03', '2022-05-03', 'gold', 25000),
(464, 6000, '000000003', 0, 15000, 0, '0000-00-00', '0000-00-00', '', 0),
(465, 6000, '000000004', 0, 15000, 0, '0000-00-00', '0000-00-00', '', 0);

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
(50, 7000, 0, '000000002', '2021-05-03'),
(51, 1000, 0, '000000002', '2021-05-04'),
(52, 1000, 0, '000000002', '2021-05-04'),
(53, 2000, 0, '000000002', '2021-05-04'),
(54, 1000, 0, '000000002', '2021-05-04');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

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
