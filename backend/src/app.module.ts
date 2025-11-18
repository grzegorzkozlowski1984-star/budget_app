import { Module } from '@nestjs/common';
import { ConnectController } from './controllers/connect.controller';
import { AccountsController } from './controllers/accounts.controller';
import { ConnectionService } from './services/connection.service';
import { MockBankAdapter } from './services/mock-bank.adapter';

@Module({
  controllers: [ConnectController, AccountsController],
  providers: [ConnectionService, MockBankAdapter]
})
export class AppModule {}
