-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DepositoDeBebida
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DepositoDeBebida
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DepositoDeBebida` DEFAULT CHARACTER SET utf8 ;
USE `DepositoDeBebida` ;

-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Funcionario` (
  `funCod` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(9) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `CPF` VARCHAR(15) NULL,
  `rua` VARCHAR(45) NULL,
  `ruaNumero` INT NULL,
  `bairro` VARCHAR(25) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` CHAR(2) NULL,
  `telefone` VARCHAR(14) NULL,
  `dataNascimento` DATE NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`funCod`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Produto` (
  `produCod` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `quantidade` INT NULL,
  `valorVenda` DOUBLE NOT NULL,
  `quantidadeMinima` INT NULL,
  `valorCompra` DOUBLE NULL,
  PRIMARY KEY (`produCod`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`cliente` (
  `clienteCod` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(15) NOT NULL,
  `RG` VARCHAR(13) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `ruaNumero` INT NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `estado` CHAR(2) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `teleCelular` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`clienteCod`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Fornecedor` (
  `fornecedorCod` INT NOT NULL AUTO_INCREMENT,
  `razaoSicial` VARCHAR(45) NOT NULL,
  `nomeFantasia` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `CNPJ` VARCHAR(17) NOT NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` CHAR(2) NOT NULL,
  `nomeContato` VARCHAR(45) NOT NULL,
  `telefoneCelular` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`fornecedorCod`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Caixa` (
  `caixaCod` INT NOT NULL AUTO_INCREMENT,
  `dataAbertura` DATE NOT NULL,
  `horaAbertura` TIME NOT NULL,
  `valorAbertura` DOUBLE NOT NULL,
  `dataFecha` DATE NULL,
  `horaFecha` TIME NULL,
  `valorFecha` DOUBLE NULL,
  `funcionarioCod` INT NOT NULL,
  PRIMARY KEY (`caixaCod`),
  INDEX `fk_Caixa_Funcionario1_idx` (`funcionarioCod` ASC),
  CONSTRAINT `fk_Caixa_Funcionario1`
    FOREIGN KEY (`funcionarioCod`)
    REFERENCES `DepositoDeBebida`.`Funcionario` (`funCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`CompraProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`CompraProduto` (
  `compraCod` INT NOT NULL AUTO_INCREMENT,
  `quantParcela` INT NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `dataCompra` DATE NOT NULL,
  `notaFiscalFornecedor` INT NOT NULL,
  `fornecedorCod` INT NOT NULL,
  PRIMARY KEY (`compraCod`),
  INDEX `fk_CompraProduto_Fornecedor1_idx` (`fornecedorCod` ASC),
  CONSTRAINT `fk_CompraProduto_Fornecedor1`
    FOREIGN KEY (`fornecedorCod`)
    REFERENCES `DepositoDeBebida`.`Fornecedor` (`fornecedorCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Pagamento` (
  `pagCod` INT NOT NULL AUTO_INCREMENT,
  `dataPaga` DATE NULL,
  `descricao` VARCHAR(100) NULL,
  `dataVencimento` DATE NOT NULL,
  `valorPagar` DOUBLE NOT NULL,
  `juros` DOUBLE NULL,
  `numeroParcela` INT NULL,
  `desconto` DOUBLE NULL,
  `observacao` VARCHAR(100) NULL,
  `compraProdutoCod` INT NULL,
  `caixaCod` INT NULL,
  PRIMARY KEY (`pagCod`),
  INDEX `fk_Pagamento_CompraProduto1_idx` (`compraProdutoCod` ASC),
  INDEX `fk_Pagamento_Caixa1_idx` (`caixaCod` ASC),
  CONSTRAINT `fk_Pagamento_CompraProduto1`
    FOREIGN KEY (`compraProdutoCod`)
    REFERENCES `DepositoDeBebida`.`CompraProduto` (`compraCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pagamento_Caixa1`
    FOREIGN KEY (`caixaCod`)
    REFERENCES `DepositoDeBebida`.`Caixa` (`caixaCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Orcamento` (
  `orcCod` INT NOT NULL AUTO_INCREMENT,
  `ValorOrc` DOUBLE NOT NULL,
  `cidadeEntrega` VARCHAR(75) NOT NULL,
  `ruaEntrega` VARCHAR(75) NOT NULL,
  `numeroEntrega` INT NOT NULL,
  `bairroEntrega` VARCHAR(45) NOT NULL,
  `dataEvento` DATE NOT NULL,
  `dataRealizado` DATE NOT NULL,
  `dataVencimento` DATE NOT NULL,
  `dataAprovacao` DATE NULL,
  `dataEntrega` DATE NULL,
  `dataDevolucao` DATE NULL,
  `observacao` VARCHAR(200) NULL,
  `clienteCod` INT NOT NULL,
  PRIMARY KEY (`orcCod`),
  INDEX `fk_Orcamento_cliente1_idx` (`clienteCod` ASC),
  CONSTRAINT `fk_Orcamento_cliente1`
    FOREIGN KEY (`clienteCod`)
    REFERENCES `DepositoDeBebida`.`cliente` (`clienteCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Venda` (
  `vendaCod` INT NOT NULL AUTO_INCREMENT,
  `vendaData` DATE NOT NULL,
  `vendaTotal` DOUBLE NOT NULL,
  `nrNota` INT NULL,
  `clienteCod` INT NULL,
  `status` CHAR(1) NULL,
  `vendaHora` TIME NOT NULL,
  PRIMARY KEY (`vendaCod`),
  INDEX `fk_Venda_cliente1_idx` (`clienteCod` ASC),
  CONSTRAINT `fk_Venda_cliente1`
    FOREIGN KEY (`clienteCod`)
    REFERENCES `DepositoDeBebida`.`cliente` (`clienteCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`Recebimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`Recebimento` (
  `receCod` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `valorRecebido` DOUBLE NOT NULL,
  `formaRecebimento` CHAR(1) NOT NULL,
  `observa` VARCHAR(100) NULL,
  `caixaCod` INT NOT NULL,
  `vendaCod` INT NOT NULL,
  PRIMARY KEY (`receCod`),
  INDEX `fk_Recebimento_Caixa1_idx` (`caixaCod` ASC),
  INDEX `fk_Recebimento_Venda1_idx` (`vendaCod` ASC),
  CONSTRAINT `fk_Recebimento_Caixa1`
    FOREIGN KEY (`caixaCod`)
    REFERENCES `DepositoDeBebida`.`Caixa` (`caixaCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recebimento_Venda1`
    FOREIGN KEY (`vendaCod`)
    REFERENCES `DepositoDeBebida`.`Venda` (`vendaCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`ItemCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`ItemCompra` (
  `compraCod` INT NOT NULL,
  `produtoCod` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `dataVencimento` DATE NULL,
  `notificado` CHAR(1) NULL,
  PRIMARY KEY (`compraCod`, `produtoCod`),
  INDEX `fk_Produto_has_CompraProduto_CompraProduto1_idx` (`compraCod` ASC),
  INDEX `fk_Produto_has_CompraProduto_Produto1_idx` (`produtoCod` ASC),
  CONSTRAINT `fk_Produto_has_CompraProduto_Produto1`
    FOREIGN KEY (`produtoCod`)
    REFERENCES `DepositoDeBebida`.`Produto` (`produCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_CompraProduto_CompraProduto1`
    FOREIGN KEY (`compraCod`)
    REFERENCES `DepositoDeBebida`.`CompraProduto` (`compraCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`OrcamentoProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`OrcamentoProduto` (
  `orcamentoCod` INT NOT NULL,
  `produtoCod` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `quantDevolvida` INT NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`orcamentoCod`, `produtoCod`),
  INDEX `fk_Orcamento_has_Produto_Produto1_idx` (`produtoCod` ASC),
  INDEX `fk_Orcamento_has_Produto_Orcamento1_idx` (`orcamentoCod` ASC),
  CONSTRAINT `fk_Orcamento_has_Produto_Orcamento1`
    FOREIGN KEY (`orcamentoCod`)
    REFERENCES `DepositoDeBebida`.`Orcamento` (`orcCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_has_Produto_Produto1`
    FOREIGN KEY (`produtoCod`)
    REFERENCES `DepositoDeBebida`.`Produto` (`produCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DepositoDeBebida`.`ItemVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DepositoDeBebida`.`ItemVenda` (
  `vendaCod` INT NOT NULL,
  `nrItem` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `produtoCod` INT NOT NULL,
  PRIMARY KEY (`vendaCod`, `nrItem`),
  INDEX `fk_Venda_has_Produto_Produto1_idx` (`produtoCod` ASC),
  INDEX `fk_Venda_has_Produto_Venda1_idx` (`vendaCod` ASC),
  CONSTRAINT `fk_Venda_has_Produto_Venda1`
    FOREIGN KEY (`vendaCod`)
    REFERENCES `DepositoDeBebida`.`Venda` (`vendaCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_has_Produto_Produto1`
    FOREIGN KEY (`produtoCod`)
    REFERENCES `DepositoDeBebida`.`Produto` (`produCod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `depositodebebida`.`funcionario` (`funCod`, `cargo`, `email`, `senha`) VALUES ('2', 'GERENTE', 'admin@admin', '12');

